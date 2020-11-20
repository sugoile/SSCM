package com.xsg.sscm.service;

import com.xsg.sscm.dto.AdminParam;
import com.xsg.sscm.dto.AdminRegisterParam;
import com.xsg.sscm.dto.AssignRoleParam;
import com.xsg.sscm.dto.EditAdminParam;
import com.xsg.sscm.model.UAdmin;
import com.xsg.sscm.po.FontMenuPO;
import com.xsg.sscm.po.FontMenuTreePO;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/9/5
 **/
public interface AdminService {
    int Register(AdminRegisterParam adminRegisterParam);

    boolean CheckLogin(String accountNumber, String password) throws Exception;

    UAdmin GetUserByUsername(String username);

    List<FontMenuPO> getMenuList(String username);

    List<FontMenuTreePO> getMenuTree(String username);

    List<AdminParam> getAdminList(Long Id, String query, Integer pageSize, Integer pageNum);

    int delAdminList(List<Long> ids, Long SelfId);

    int delAdminOne(Long id, Long SelfId);

    int updateAdmin(Long ID, EditAdminParam editAdminParam);

    EditAdminParam getEditAdmin(Long ID);

    int updateStatu(Long ID, Integer Statu);

    int assignAdminToRole(Long ID, List<Long> RoleIds);

    List<AssignRoleParam> getAssignRoleList();

    List<Long> checkLinkRole(Long id);
}
