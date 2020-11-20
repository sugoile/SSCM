package com.xsg.sscm.dao;

import com.xsg.sscm.dto.AssignAdminParam;
import com.xsg.sscm.dto.RoleParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dao
 * @author: xsg
 * @date: 2020/10/17
 **/
public interface RoleDao {
    List<RoleParam> getRoleList(@Param(value="query") String query);

    Integer maxSort();

    Long count(@Param(value="RoleName")String RoleName);

    Long checkRoleAdminRel(@Param(value = "roleID") Long roleID);

    List<AssignAdminParam> getAssignAdminList();

    List<Long> checkLinkAdmin(@Param(value = "roleID") Long roleID);

    List<Long> checkLinkMenu(@Param(value= "roleID") Long roleID);

    List<Long> checkLinkApi(@Param(value= "roleID") Long roleID);

}
