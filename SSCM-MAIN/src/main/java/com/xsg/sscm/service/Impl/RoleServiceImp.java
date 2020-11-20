package com.xsg.sscm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xsg.sscm.dao.AdminRelationDao;
import com.xsg.sscm.dao.RoleDao;
import com.xsg.sscm.dto.AssignAdminParam;
import com.xsg.sscm.dto.RoleParam;
import com.xsg.sscm.mapper.UAdminRoleMapper;
import com.xsg.sscm.mapper.URoleApiMapper;
import com.xsg.sscm.mapper.URoleFontMenuMapper;
import com.xsg.sscm.mapper.URoleMapper;
import com.xsg.sscm.model.*;
import com.xsg.sscm.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @des:
 * @package: com.xsg.sscm.service.Impl
 * @author: xsg
 * @date: 2020/9/13
 **/
@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private URoleMapper uRoleMapper;
    @Autowired
    private UAdminRoleMapper uAdminRoleMapper;
    @Autowired
    private URoleFontMenuMapper uRoleFontMenuMapper;
    @Autowired
    private URoleApiMapper uRoleApiMapper;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleParam> getRoleList(String query, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return roleDao.getRoleList(query);
    }

    @Override
    public int addRole(RoleParam roleParam) {
        if (roleDao.count(roleParam.getRoleName()) == 0) {
            URole role = new URole();
            BeanUtils.copyProperties(roleParam, role);
            role.setId(null);
            role.setSort(roleDao.maxSort() + 1);
            return uRoleMapper.insertSelective(role);
        } else {
            return -1;
        }
    }

    @Override
    public int updateRole(Long id, RoleParam roleParam) {
        if (roleDao.count(roleParam.getRoleName()) == 0) {
            URole role = new URole();
            BeanUtils.copyProperties(roleParam, role);
            role.setId(id);
            role.setSort(roleDao.maxSort() + 1);
            return uRoleMapper.updateByPrimaryKeySelective(role);
        } else if (roleDao.count(roleParam.getRoleName()) == 1) {
            URoleExample uRoleExample = new URoleExample();
            uRoleExample.createCriteria().andRoleNameEqualTo(roleParam.getRoleName());
            Long Selid = uRoleMapper.selectByExample(uRoleExample).get(0).getId();
            if (Selid == id) {
                URole role = new URole();
                BeanUtils.copyProperties(roleParam, role);
                role.setId(id);
                role.setSort(roleDao.maxSort() + 1);
                return uRoleMapper.updateByPrimaryKeySelective(role);
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }

    @Override
    public int delRole(Long id) {
        /*id = 1 => 系统管理员*/
        if (id == 1) {
            return -1;
        } else {
            UAdminRoleExample uAdminRoleExample = new UAdminRoleExample();
            uAdminRoleExample.createCriteria().andRoleIdEqualTo(id);
            uAdminRoleMapper.deleteByExample(uAdminRoleExample);
            URoleFontMenuExample uRoleFontMenuExample = new URoleFontMenuExample();
            uRoleFontMenuExample.createCriteria().andRoleIdEqualTo(id);
            uRoleFontMenuMapper.deleteByExample(uRoleFontMenuExample);
            URoleApiExample uRoleApiExample = new URoleApiExample();
            uRoleApiExample.createCriteria().andRoleIdEqualTo(id);
            uRoleApiMapper.deleteByExample(uRoleApiExample);
            return uRoleMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int delRoleList(List<Long> ids) {
        ids = ids.stream().filter(id -> id != 1).collect(Collectors.toList());
        URoleExample uRoleExample = new URoleExample();
        uRoleExample.createCriteria().andIdIn(ids);
        UAdminRoleExample uAdminRoleExample = new UAdminRoleExample();
        uAdminRoleExample.createCriteria().andRoleIdIn(ids);
        uAdminRoleMapper.deleteByExample(uAdminRoleExample);
        URoleFontMenuExample uRoleFontMenuExample = new URoleFontMenuExample();
        uRoleFontMenuExample.createCriteria().andRoleIdIn(ids);
        uRoleFontMenuMapper.deleteByExample(uRoleFontMenuExample);
        URoleApiExample uRoleApiExample = new URoleApiExample();
        uRoleApiExample.createCriteria().andRoleIdIn(ids);
        uRoleApiMapper.deleteByExample(uRoleApiExample);
        return uRoleMapper.deleteByExample(uRoleExample);
    }

    @Override
    public Long checkRoleAdminRel(Long roleID) {
        return roleDao.checkRoleAdminRel(roleID);
    }

    @Override
    public Long checkRoleAdminRelList(List<Long> ids) {
        long count = 0;
        for (Long id : ids) {
            count += roleDao.checkRoleAdminRel(id);
        }
        return count;
    }

    @Override
    public List<AssignAdminParam> getAssignAdminList() {
        return roleDao.getAssignAdminList();
    }

    @Override
    public List<Long> checkLinkAdmin(Long roleID) {
        return roleDao.checkLinkAdmin(roleID);
    }

    /**
     * id = 1 => 系统管理员
     *
     * @param roleId
     * @param AdminIds
     * @return
     */
    @Override
    public int assignRoleToAdmin(Long roleId, List<Long> AdminIds) {
        int count = -1;
        if (uRoleMapper.selectByPrimaryKey(roleId) != null) {
            UAdminRoleExample uAdminRoleExample = new UAdminRoleExample();
            uAdminRoleExample.createCriteria().andRoleIdEqualTo(roleId);
            count = uAdminRoleMapper.deleteByExample(uAdminRoleExample);
            if (!CollectionUtils.isEmpty(AdminIds)) {
                count = 0;
                for (Long id : AdminIds) {
                    UAdminRole uAdminRole = new UAdminRole();
                    uAdminRole.setRoleId(roleId);
                    uAdminRole.setAdminId(id);
                    uAdminRoleMapper.insert(uAdminRole);
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public List<Long> checkLinkMenu(Long roleID) {
        return roleDao.checkLinkMenu(roleID);
    }

    @Override
    public int assignRoleToMenu(Long roleId, List<Long> MenuIds) {
        int count = -1;
        if (uRoleMapper.selectByPrimaryKey(roleId) != null) {
            URoleFontMenuExample uRoleFontMenuExample = new URoleFontMenuExample();
            uRoleFontMenuExample.createCriteria().andRoleIdEqualTo(roleId);
            count = uRoleFontMenuMapper.deleteByExample(uRoleFontMenuExample);
            if (!CollectionUtils.isEmpty(MenuIds)) {
                count = 0;
                for (Long id : MenuIds) {
                    URoleFontMenu uRoleFontMenu = new URoleFontMenu();
                    uRoleFontMenu.setRoleId(roleId);
                    uRoleFontMenu.setFontMenuId(id);
                    uRoleFontMenuMapper.insert(uRoleFontMenu);
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public List<Long> checkLinkApi(Long roleID) {
        return roleDao.checkLinkApi(roleID);
    }

    @Override
    public int assignRoleToApi(Long roleId, List<Long> ApiIds) {
        int count = -1;
        if (uRoleMapper.selectByPrimaryKey(roleId) != null) {
            URoleApiExample uRoleApiExample = new URoleApiExample();
            uRoleApiExample.createCriteria().andRoleIdEqualTo(roleId);
            count = uRoleApiMapper.deleteByExample(uRoleApiExample);
            if (!CollectionUtils.isEmpty(ApiIds)) {
                count = 0;
                for (Long id : ApiIds) {
                    URoleApi uRoleApi = new URoleApi();
                    uRoleApi.setRoleId(roleId);
                    uRoleApi.setApiId(id);
                    uRoleApiMapper.insert(uRoleApi);
                    count++;
                }
            }
        }
        return count;
    }
}
