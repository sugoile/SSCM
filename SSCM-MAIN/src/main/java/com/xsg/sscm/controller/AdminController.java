package com.xsg.sscm.controller;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.dto.AdminRegisterParam;
import com.xsg.sscm.dto.EditAdminParam;
import com.xsg.sscm.po.FontMenuPO;
import com.xsg.sscm.po.FontMenuTreePO;
import com.xsg.sscm.service.AdminService;
import com.xsg.sscm.utils.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @des: 后台管理员接口
 * @package: com.xsg.sscm.controller
 * @author: xsg
 * @date: 2020/9/5
 **/
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/Register")
    public REData Register(@Validated @RequestBody AdminRegisterParam adminRegisterParam, BindingResult bindingResult) {
        int result = adminService.Register(adminRegisterParam);
        System.out.println(result);
        if (result == -1) {
            return REData.failed("该账号已存在");
        } else if (result == 0) {
            return REData.failed("某些原因,创造失败...");
        } else {
            return REData.success("新建账号成功", null);
        }
    }

    @GetMapping(value = "/getMenuList")
    public REData getMenuList(@RequestParam("username") String username) {
        List<FontMenuPO> menuList = adminService.getMenuList(username);
        return REData.success(menuList);
    }

    @GetMapping(value = "/getMenuTree")
    public REData getMenuTree(@RequestParam("username") String username) {
        List<FontMenuTreePO> menuTree = adminService.getMenuTree(username);
        return REData.success(menuTree);
    }

    @GetMapping(value = "/getAdminList/{ID}")
    public REData getAdminList(@PathVariable("ID") Long ID,
                               @RequestParam(value = "query", required = false) String query,
                               @RequestParam(value = "pageSize",defaultValue = "8") Integer pageSize,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return REData.success(CommonPage.resultPage(adminService.getAdminList(ID, query,  pageSize, pageNum)));
    }


    @GetMapping(value = "/delAdminList/{selfID}")
    public REData delAdminList(@PathVariable("selfID") Long selfID,
                               @RequestParam("ids") List<Long> ids) {
        int count = adminService.delAdminList(ids, selfID);
        if (count < 1) {
            return REData.failed("删除失败");
        } else {
            return REData.success("删除成功", null);
        }
    }

    @GetMapping(value = "/delAdminOne/{selfID}")
    public REData delAdminOne(@PathVariable("selfID") Long selfID,
                              @RequestParam("id") Long id) {
        int count = adminService.delAdminOne(id, selfID);
        if (count == -1) {
            return REData.failed("不能删除自身");
        } else if (count == 0) {
            return REData.failed("删除失败");
        } else {
            return REData.success("删除成功", null);
        }
    }

    @PostMapping(value = "/updateAdmin/{Id}")
    public REData updateAdmin(@PathVariable("Id") Long ID,
                              @Validated @RequestBody EditAdminParam editAdminParam, BindingResult bindingResult){
        int count = adminService.updateAdmin(ID, editAdminParam);
        if(count > 0){
            return REData.success("更改成功", null);
        }else{
            return REData.failed("更改失败");
        }
    }

    @GetMapping(value = "/getEditAdmin/{Id}")
    public REData getEditAdmin(@PathVariable("Id") Long ID){
        return REData.success(adminService.getEditAdmin(ID));
    }

    @GetMapping(value = "/updateStatu/{Id}")
    public REData updateStatu(@PathVariable("Id") Long ID,
                              @RequestParam("status") Integer status){
        if(adminService.updateStatu(ID, status) > 0 && status == 1){
            return REData.success("更改为开启状态", null);
        }else if(adminService.updateStatu(ID, status) > 0 && status == 0){
            return REData.success("更改为关闭状态", null);
        }else{
            return REData.failed("更改状态失败");
        }
    }
    @PostMapping(value = "/assignAdminToRole/{Id}")
    public REData assignAdminToRole(@PathVariable("Id") Long Id, @RequestParam("ids") List<Long> RoleIds) {
        int count = adminService.assignAdminToRole(Id, RoleIds);
        if(count == -1){
            return REData.failed("没有该用户，分配失败");
        }else {
            return REData.success("分配角色成功", count);
        }
    }

    @GetMapping(value = "/getAssignRoleList")
    public REData getAssignRoleList(){
        return REData.success(adminService.getAssignRoleList());
    }

    @GetMapping(value = "/checkLinkRole/{Id}")
    public REData checkLinkRole(@PathVariable("Id") Long Id) {
        return REData.success(adminService.checkLinkRole(Id));
    }
}
