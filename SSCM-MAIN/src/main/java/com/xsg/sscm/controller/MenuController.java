package com.xsg.sscm.controller;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @des: 菜单管理接口
 * @package: com.xsg.sscm.controller
 * @author: xsg
 * @date: 2020/10/21
 **/
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/getMenuList")
    public REData getMenuList(){
        return REData.success(menuService.getMenuList());
    }

    @GetMapping(value = "/getMenuTree")
    public REData getMenuTree(){
        return REData.success(menuService.getMenuTree());
    }
}
