package com.xsg.sscm.dao;

import com.xsg.sscm.dto.AdminParam;
import com.xsg.sscm.dto.AssignRoleParam;
import com.xsg.sscm.dto.EditAdminParam;
import com.xsg.sscm.model.UFontMenu;
import com.xsg.sscm.model.URole;
import com.xsg.sscm.po.ApiPO;
import com.xsg.sscm.po.FontMenuPO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @des: 用户一些dao接口(用户id查询role)
 * @package: com.xsg.sscm.dao
 * @author: xsg
 * @date: 2020/9/14
 **/
public interface AdminRelationDao {
    List<URole> getRolesByUserID(long id);

    List<ApiPO> getApiUrlByUserName(String username);

    List<FontMenuPO> getMenusByUserName(String username);

    List<AdminParam> getAdminList(@Param(value="query") String query);

    List<AdminParam> getAdminListNotAdmin(@Param(value="query") String query);

    EditAdminParam getEditAdmin(Long ID);

    List<AssignRoleParam> getAssignRoleList();

    List<Long> checkLinkRole(@Param(value = "id") Long ID);

}
