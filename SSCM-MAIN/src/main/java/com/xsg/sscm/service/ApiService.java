package com.xsg.sscm.service;

import com.xsg.sscm.dto.ApiParentParam;
import com.xsg.sscm.dto.ApiTreeParam;
import com.xsg.sscm.model.UApi;
import com.xsg.sscm.po.ApiPO;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/9/16
 **/
public interface ApiService {
    List<ApiPO> getApiUrlByUserName(String username);

    List<UApi> getApiList();

    List<ApiTreeParam> getApiTree();

    List<Long> checkLinkRole(Long ApiID);

    int assignApiToRole(Long ApiId, List<Long> roleIds);

    List<ApiParentParam> getOneAndTwoApis();

    int addApi(UApi uApi);

    int updateApi(Long ID, UApi uApi);

    int updatePApi(UApi uApi);

    int delApi(Long ID);
}
