package com.xsg.sscm.dao;

import com.xsg.sscm.dto.MenuListParam;
import com.xsg.sscm.dto.MenuTreeParam;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.dao
 * @author: xsg
 * @date: 2020/10/21
 **/
public interface MenuDao {

    List<MenuListParam> getMenuList();

    List<MenuTreeParam> getMenuTree();
}
