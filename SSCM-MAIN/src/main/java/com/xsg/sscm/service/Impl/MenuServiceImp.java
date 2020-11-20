package com.xsg.sscm.service.Impl;

import com.xsg.sscm.dao.MenuDao;
import com.xsg.sscm.dto.MenuListParam;
import com.xsg.sscm.dto.MenuTreeParam;
import com.xsg.sscm.mapper.UFontMenuMapper;
import com.xsg.sscm.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @des: 菜单管理处理
 * @package: com.xsg.sscm.service.Impl
 * @author: xsg
 * @date: 2020/10/21
 **/
@Service
public class MenuServiceImp implements MenuService {

    @Autowired
    private UFontMenuMapper uFontMenuMapper;
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<MenuListParam> getMenuList() {
        return menuDao.getMenuList();
    }

    @Override
    public List<MenuTreeParam> getMenuTree() {
        List<MenuTreeParam> menuTrees = menuDao.getMenuTree();
        List<MenuTreeParam> Trees = new ArrayList<>();
        for (MenuTreeParam menuTree : menuTrees) {
            if (menuTree.getPid() == 0) {
                Trees.add(menuTree);
            }

            for (MenuTreeParam it : menuTrees) {
                if (menuTree.getId() == it.getPid()) {
                    if (menuTree.getChildren() == null) {
                        menuTree.setChildren(new ArrayList<>());
                    }
                    MenuListParam menuListParam = new MenuListParam();
                    BeanUtils.copyProperties(it, menuListParam);
                    menuTree.getChildren().add(menuListParam);
                }
            }
        }
        return Trees;
    }
}
