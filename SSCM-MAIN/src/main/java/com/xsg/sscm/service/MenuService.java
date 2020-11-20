package com.xsg.sscm.service;

import com.xsg.sscm.dto.MenuListParam;
import com.xsg.sscm.dto.MenuTreeParam;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service
 * @author: xsg
 * @date: 2020/10/21
 **/
public interface MenuService {

    List<MenuListParam> getMenuList();

    List<MenuTreeParam> getMenuTree();
}
