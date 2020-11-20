package com.xsg.sscm.service;

import com.xsg.sscm.dto.AssignAdminParam;
import com.xsg.sscm.dto.RoleParam;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/9/13
 **/
public interface RoleService {
    List<RoleParam> getRoleList(String query, Integer pageSize, Integer pageNum);

    int addRole(RoleParam roleParam);

    int updateRole(Long id, RoleParam roleParam);

    int delRole(Long id);

    int delRoleList(List<Long> ids);

    Long checkRoleAdminRel(Long roleID);

    Long checkRoleAdminRelList(List<Long> ids);

    List<AssignAdminParam> getAssignAdminList();

    List<Long> checkLinkAdmin(Long roleID);

    int assignRoleToAdmin(Long roleId, List<Long> AdminIds);

    List<Long> checkLinkMenu(Long roleID);

    int assignRoleToMenu(Long roleId, List<Long> MenuIds);

    List<Long> checkLinkApi(Long roleID);

    int assignRoleToApi(Long roleId, List<Long> ApiIds);

}
