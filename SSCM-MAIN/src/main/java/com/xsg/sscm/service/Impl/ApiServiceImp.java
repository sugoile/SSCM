package com.xsg.sscm.service.Impl;

import com.xsg.sscm.dao.AdminRelationDao;
import com.xsg.sscm.dao.ApiDao;
import com.xsg.sscm.dto.ApiParentParam;
import com.xsg.sscm.dto.ApiTreeParam;
import com.xsg.sscm.dto.MenuListParam;
import com.xsg.sscm.dto.MenuTreeParam;
import com.xsg.sscm.mapper.UApiMapper;
import com.xsg.sscm.mapper.URoleApiMapper;
import com.xsg.sscm.model.*;
import com.xsg.sscm.po.ApiPO;
import com.xsg.sscm.service.ApiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service.Impl
 * @author: xsg
 * @date: 2020/9/16
 **/
@Service
public class ApiServiceImp implements ApiService {

    @Autowired
    private AdminRelationDao adminRelationDao;
    @Autowired
    private UApiMapper uApiMapper;
    @Autowired
    private ApiDao apiDao;
    @Autowired
    private URoleApiMapper uRoleApiMapper;

    @Override
    public List<ApiPO> getApiUrlByUserName(String username) {
        return adminRelationDao.getApiUrlByUserName(username);
    }

    @Override
    public List<UApi> getApiList() {
        return uApiMapper.selectByExample(new UApiExample());
    }

    @Override
    public List<ApiTreeParam> getApiTree() {
        List<ApiTreeParam> ApiList = apiDao.getApiTree();
        List<ApiTreeParam> apiTreeParams = new ArrayList<>();
        for (ApiTreeParam apiTreeParam : ApiList) {
            if (apiTreeParam.getPid() == 0) {
                apiTreeParams.add(apiTreeParam);
            }

            for (ApiTreeParam it : ApiList) {
                if (apiTreeParam.getId() == it.getPid()) {
                    if (apiTreeParam.getChildren() == null) {
                        apiTreeParam.setChildren(new ArrayList<>());
                    }
                    apiTreeParam.getChildren().add(it);
                }
            }
        }
        return apiTreeParams;
    }

    @Override
    public List<Long> checkLinkRole(Long ApiID) {
        return apiDao.checkLinkRole(ApiID);
    }

    @Override
    public int assignApiToRole(Long ApiId, List<Long> roleIds) {
        int count = -1;
        if (uApiMapper.selectByPrimaryKey(ApiId) != null) {
            URoleApiExample uRoleApiExample = new URoleApiExample();
            uRoleApiExample.createCriteria().andApiIdEqualTo(ApiId);
            count = uRoleApiMapper.deleteByExample(uRoleApiExample);
            if (!CollectionUtils.isEmpty(roleIds)) {
                count = 0;
                for (Long id : roleIds) {
                    URoleApi uRoleApi = new URoleApi();
                    uRoleApi.setApiId(ApiId);
                    uRoleApi.setRoleId(id);
                    uRoleApiMapper.insert(uRoleApi);
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public List<ApiParentParam> getOneAndTwoApis() {
        List<ApiParentParam> oneApi = apiDao.getOneApi();
        for (int i = 0; i < oneApi.size(); i++) {
            List<ApiParentParam> twoApi = apiDao.getTwoApi(oneApi.get(i).getValue());
            ApiParentParam apiParentParam = new ApiParentParam();
            oneApi.get(i).setChildren(twoApi);
        }
        return oneApi;
    }

    @Override
    public int addApi(UApi uApi) {
        UApiExample uApiExample = new UApiExample();
        uApiExample.createCriteria().andApiUrlEqualTo(uApi.getApiUrl());
        if (uApiMapper.selectByExample(uApiExample).size() == 0) {
            uApi.setSort(GETSORT(uApi));
            return uApiMapper.insertSelective(uApi);
        } else {
            return -1;
        }
    }

    @Override
    public int updateApi(Long ID, UApi uApi) {
        UApiExample uApiExample = new UApiExample();
        uApiExample.createCriteria().andApiUrlEqualTo(uApi.getApiUrl());
        List<UApi> uApis = uApiMapper.selectByExample(uApiExample);
        if (uApis.size() == 0) {
            uApi.setId(ID);
            if (uApi.getPid() != uApiMapper.selectByPrimaryKey(ID).getPid()) {
                uApi.setSort(GETSORT(uApi));
            }
            return uApiMapper.updateByPrimaryKeySelective(uApi);
        } else {
            if (uApis.get(0).getId() == ID) {
                uApi.setId(ID);
                System.out.println(uApi.getPid() + "----" + uApiMapper.selectByPrimaryKey(ID).getPid());
                if (uApi.getPid() != uApiMapper.selectByPrimaryKey(ID).getPid()) {
                    uApi.setSort(GETSORT(uApi));
                }
                return uApiMapper.updateByPrimaryKeySelective(uApi);
            } else {
                return -1;
            }
        }
    }

    @Override
    public int updatePApi(UApi uApi) {
        uApi.setSort(null);
        uApi.setApiMethod(null);
        uApi.setApiUrl(null);
        uApi.setPid(null);
        return uApiMapper.updateByPrimaryKeySelective(uApi);
    }

    @Override
    public int delApi(Long ID) {
        UApiExample uApiExample = new UApiExample();
        uApiExample.createCriteria().andPidEqualTo(ID);
        List<UApi> api = uApiMapper.selectByExample(uApiExample);
        if(api.size() > 0){
            return -1;
        }else{
            URoleApiExample uRoleApiExample = new URoleApiExample();
            uRoleApiExample.createCriteria().andApiIdEqualTo(ID);
            uRoleApiMapper.deleteByExample(uRoleApiExample);
            return uApiMapper.deleteByPrimaryKey(ID);
        }
    }

    public int GETSORT(UApi uApi) {
        if (uApi.getPid() == 0) {
            UApiExample uApiExample1 = new UApiExample();
            uApiExample1.createCriteria().andPidEqualTo(uApi.getPid());
            if (uApiMapper.selectByExample(uApiExample1) == null) {
                return 10;
            } else {
                int maxSort = apiDao.MaxSort((long) 0);
                return maxSort + 10;
            }
        } else {
            Long pid = uApiMapper.selectByPrimaryKey(uApi.getPid()).getPid();
            UApiExample uApiExample1 = new UApiExample();
            uApiExample1.createCriteria().andPidEqualTo(uApi.getPid());
            if (uApiMapper.selectByExample(uApiExample1).size() == 0) {
                if (pid == 0) {
                    return uApiMapper.selectByPrimaryKey(uApi.getPid()).getSort() * 10;
                } else {
                    return uApiMapper.selectByPrimaryKey(uApi.getPid()).getSort() + 1;
                }
            } else {
                int maxSort = apiDao.MaxSort(uApi.getPid());
                if (pid == 0) {
                    return maxSort + 20;
                } else {
                    return maxSort + 1;
                }
            }
        }
    }
}


