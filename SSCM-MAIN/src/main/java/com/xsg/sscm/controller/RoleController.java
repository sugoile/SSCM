package com.xsg.sscm.controller;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.dto.RoleParam;
import com.xsg.sscm.service.RoleService;
import com.xsg.sscm.utils.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @des: 后台角色管理接口
 * @package: com.xsg.sscm.controller
 * @author: xsg
 * @date: 2020/10/16
 **/
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/getRoleList")
    public REData getRoleList(@RequestParam(value = "query", required = false) String query,
                              @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return REData.success(CommonPage.resultPage(roleService.getRoleList(query, pageSize, pageNum)));
    }

    @PostMapping(value = "/addRole")
    public REData addRole(@Validated @RequestBody RoleParam roleParam, BindingResult bindingResult) {
        int count = roleService.addRole(roleParam);
        if (count > 0) {
            return REData.success("添加新角色成功", null);
        } else if (count == -1) {
            return REData.failed("该角色名已经存在");
        } else {
            return REData.failed("添加失败");
        }
    }

    @PostMapping(value = "/updateRole/{Id}")
    public REData updateRole(@PathVariable("Id") Long ID,
                             @Validated @RequestBody RoleParam roleParam, BindingResult bindingResult) {
        int count = roleService.updateRole(ID, roleParam);
        if (count > 0) {
            return REData.success("更改成功", null);
        } else if (count == -1) {
            return REData.failed("该更改的名字已经存在");
        } else {
            return REData.failed("更改失败");
        }
    }

    @GetMapping(value = "/delRole/{Id}")
    public REData delRole(@PathVariable("Id") Long ID) {
        int count = roleService.delRole(ID);
        if (count > 0) {
            return REData.success("删除成功", null);
        } else if (count == -1) {
            return REData.failed("不能删除系统管理员该角色");
        } else {
            return REData.failed("删除失败");
        }
    }

    @GetMapping(value = "/delRoleList")
    public REData delRoleList(@RequestParam("ids") List<Long> ids) {
        int count = roleService.delRoleList(ids);
        if (count > 0) {
            return REData.success("删除成功", null);
        } else {
            return REData.failed("删除失败");
        }
    }

    @GetMapping(value = "/checkRoleAdminRel/{roleID}")
    public REData checkRoleAdminRel(@PathVariable("roleID") Long roleID) {
        Long count = roleService.checkRoleAdminRel(roleID);
        return REData.success(count);
    }

    @GetMapping(value = "/checkRoleAdminRelList")
    public REData checkRoleAdminRelList(@RequestParam("Ids") List<Long> ids) {
        Long count = roleService.checkRoleAdminRelList(ids);
        return REData.success(count);
    }

    @GetMapping(value = "/getAssignAdminList")
    public REData getAssignAdminList() {
        return REData.success(roleService.getAssignAdminList());
    }

    @GetMapping(value = "/checkLinkAdmin/{roleID}")
    public REData checkLinkAdmin(@PathVariable("roleID") Long roleID) {
        return REData.success(roleService.checkLinkAdmin(roleID));
    }

    @PostMapping(value = "/assignRoleToAdmin/{roleId}")
    public REData assignRoleToAdmin(@PathVariable("roleId") Long roleId, @RequestParam("ids") List<Long> AdminIds) {
        int count = roleService.assignRoleToAdmin(roleId, AdminIds);
        if(count == -1){
            return REData.failed("没有该角色，分配失败");
        }else {
            return REData.success("分配用户成功", count);
        }
    }

    @GetMapping(value = "/checkLinkMenu/{roleID}")
    public REData checkLinkMenu(@PathVariable("roleID") Long roleID){
        return REData.success(roleService.checkLinkMenu(roleID));
    }

    @PostMapping(value = "/assignRoleToMenu/{roleId}")
    public REData assignRoleToMenu(@PathVariable("roleId") Long roleId, @RequestParam("ids") List<Long> menuIds){
        int count = roleService.assignRoleToMenu(roleId, menuIds);
        if(count == -1){
            return REData.failed("没有该角色，分配失败");
        }else {
            return REData.success("分配菜单成功", count);
        }
    }

    @GetMapping(value = "/checkLinkApi/{roleID}")
    public REData checkLinkApi(@PathVariable("roleID") Long roleID){
        return REData.success(roleService.checkLinkApi(roleID));
    }

    @PostMapping(value = "/assignRoleToApi/{roleId}")
    public REData assignRoleToApi(@PathVariable("roleId") Long roleId, @RequestParam("ids") List<Long> apiIds){
        int count = roleService.assignRoleToApi(roleId, apiIds);
        if(count == -1){
            return REData.failed("没有该角色，分配失败");
        }else {
            return REData.success("分配权限成功", count);
        }
    }

}
