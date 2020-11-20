package com.xsg.sscm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xsg.sscm.dao.AdminRelationDao;
import com.xsg.sscm.dto.AdminParam;
import com.xsg.sscm.dto.AdminRegisterParam;
import com.xsg.sscm.dto.AssignRoleParam;
import com.xsg.sscm.dto.EditAdminParam;
import com.xsg.sscm.mapper.UAdminMapper;
import com.xsg.sscm.mapper.UAdminRoleMapper;
import com.xsg.sscm.model.*;
import com.xsg.sscm.po.FontMenuPO;
import com.xsg.sscm.po.FontMenuTreePO;
import com.xsg.sscm.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @des:
 * @package: com.xsg.sscm.service.Impl
 * @author: xsg
 * @date: 2020/9/5
 **/
@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private UAdminMapper uAdminMapper;
    @Autowired
    private UAdminRoleMapper uAdminRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AdminRelationDao adminRelationDao;


    public int Register(AdminRegisterParam adminRegisterParam) {
        UAdmin uAdmin = new UAdmin();
        BeanUtils.copyProperties(adminRegisterParam, uAdmin);
        uAdmin.setCreateTime(new Date());
        //查询是否有相同账号
        UAdminExample uAdminExample = new UAdminExample();
        uAdminExample.createCriteria().andUsernameEqualTo(uAdmin.getUsername());
        List<UAdmin> uAdmins = uAdminMapper.selectByExample(uAdminExample);
        if (uAdmins.size() > 0) {
            return -1;
        }
        String Password = passwordEncoder.encode(uAdmin.getPassword());
        uAdmin.setPassword(Password);
        return uAdminMapper.insertSelective(uAdmin);
    }

    @Override
    public boolean CheckLogin(String username, String password) throws Exception {
        UAdminExample uAdminExample = new UAdminExample();
        uAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UAdmin> uAdmins = uAdminMapper.selectByExample(uAdminExample);
        if (uAdmins.size() == 0 || uAdmins == null) {
            throw new Exception("账号不存在！！！");
        } else {
            String encodepassword = uAdmins.get(0).getPassword();
            if (!passwordEncoder.matches(password, encodepassword)) {
                throw new Exception("密码错误！！！");
            } else {
                return true;
            }
        }
    }

    @Override
    public UAdmin GetUserByUsername(String username) {
        UAdminExample uAdminExample = new UAdminExample();
        uAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UAdmin> uAdmins = uAdminMapper.selectByExample(uAdminExample);
        if (uAdmins.size() > 0 || uAdmins != null) {
            return uAdmins.get(0);
        }
        return null;
    }

    @Override
    public List<FontMenuPO> getMenuList(String username) {
        return adminRelationDao.getMenusByUserName(username);
    }

    @Override
    public List<FontMenuTreePO> getMenuTree(String username) {
        List<FontMenuPO> menus = adminRelationDao.getMenusByUserName(username);
        List<FontMenuTreePO> fontMenuTreePOS = new ArrayList<>();
        for (FontMenuPO menu : menus) {
            if (menu.getPid() == 0) {
                FontMenuTreePO fontMenuTreePO = new FontMenuTreePO();
                FontMenuTreePO menuTree = setFontMenuTreePO(fontMenuTreePO, menu);
                fontMenuTreePOS.add(menuTree);
            }
        }
        for (FontMenuTreePO fontMenuTreePO : fontMenuTreePOS) {
            List<FontMenuPO> children = new ArrayList<>();
            for (FontMenuPO menu : menus) {
                if (fontMenuTreePO.getId() == menu.getPid()) {
                    children.add(menu);
                }
            }
            fontMenuTreePO.setChildren(children);
        }
        return fontMenuTreePOS;
    }

    /**
     * role.id == 1 系统管理员 => 返回列表所有用户
     * role.id == 2 管理员 => 返回列表中除管理员和系统管理员的用户
     **/

    @Override
    public List<AdminParam> getAdminList(Long Id, String query, Integer pageSize, Integer pageNum) {
        List<URole> roles = adminRelationDao.getRolesByUserID(Id);
        boolean Oneflag = false;
        boolean Twoflag = false;
        for (URole role : roles) {
            if (role.getId() == 1) {
                Oneflag = true;
            } else if (role.getId() == 2) {
                Twoflag = true;
            }
        }
        if (Oneflag || (Oneflag && Twoflag)) {
            PageHelper.startPage(pageNum, pageSize);
            return adminRelationDao.getAdminList(query);
        } else if (Twoflag) {
            PageHelper.startPage(pageNum, pageSize);
            return adminRelationDao.getAdminListNotAdmin(query);
        } else {
            return null;
        }
    }

    @Override
    public int delAdminList(List<Long> Ids, Long SelfId) {
        //排除删除自身
        Ids = Ids.stream().filter(id -> id != SelfId).collect(Collectors.toList());
        UAdminExample uAdminExample = new UAdminExample();
        uAdminExample.createCriteria().andIdIn(Ids);
        UAdminRoleExample uAdminRoleExample = new UAdminRoleExample();
        uAdminRoleExample.createCriteria().andAdminIdIn(Ids);
        uAdminRoleMapper.deleteByExample(uAdminRoleExample);
        return uAdminMapper.deleteByExample(uAdminExample);
    }

    @Override
    public int delAdminOne(Long id, Long SelfId) {
        if (id == SelfId) {
            return -1;
        } else {
            UAdminRoleExample uAdminRoleExample = new UAdminRoleExample();
            uAdminRoleExample.createCriteria().andAdminIdEqualTo(id);
            uAdminRoleMapper.deleteByExample(uAdminRoleExample);
            return uAdminMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int updateAdmin(Long ID, EditAdminParam editAdminParam) {
        UAdmin uAdmin = new UAdmin();
        BeanUtils.copyProperties(editAdminParam, uAdmin);
        uAdmin.setId(ID);
        uAdmin.setUsername(null);
        if(editAdminParam.getPassword() == null|| editAdminParam.getPassword() == ""){
            uAdmin.setPassword(uAdminMapper.selectByPrimaryKey(ID).getPassword());
        }else{
            String Password = passwordEncoder.encode(uAdmin.getPassword());
            uAdmin.setPassword(Password);
        }
        return uAdminMapper.updateByPrimaryKeySelective(uAdmin);
    }

    @Override
    public EditAdminParam getEditAdmin(Long ID) {
        return adminRelationDao.getEditAdmin(ID);
    }

    @Override
    public int updateStatu(Long ID, Integer Statu) {
        UAdmin uAdmin = new UAdmin();
        uAdmin.setId(ID);
        uAdmin.setStatus(Statu);
        return uAdminMapper.updateByPrimaryKeySelective(uAdmin);
    }

    @Override
    public int assignAdminToRole(Long ID, List<Long> RoleIds) {
        int count = -1;
        if (uAdminMapper.selectByPrimaryKey(ID) != null) {
            UAdminRoleExample uAdminRoleExample = new UAdminRoleExample();
            uAdminRoleExample.createCriteria().andAdminIdEqualTo(ID);
            count = uAdminRoleMapper.deleteByExample(uAdminRoleExample);
            if(!CollectionUtils.isEmpty(RoleIds)){
                count = 0;
                for(Long id : RoleIds){
                    UAdminRole uAdminRole = new UAdminRole();
                    uAdminRole.setRoleId(id);
                    uAdminRole.setAdminId(ID);
                    uAdminRoleMapper.insert(uAdminRole);
                    count ++;
                }
            }
        }
        return count;
    }

    @Override
    public List<AssignRoleParam> getAssignRoleList() {
        return adminRelationDao.getAssignRoleList();
    }

    @Override
    public List<Long> checkLinkRole(Long id) {
        return adminRelationDao.checkLinkRole(id);
    }

    public FontMenuTreePO setFontMenuTreePO(FontMenuTreePO menuTree, FontMenuPO menu) {
        menuTree.setId(menu.getId());
        menuTree.setPid(menu.getPid());
        menuTree.setFontIcon(menu.getFontIcon());
        menuTree.setFontMenuName(menu.getFontMenuName());
        menuTree.setPath(menu.getPath());
        menuTree.setSort(menu.getSort());
        return menuTree;
    }

}


