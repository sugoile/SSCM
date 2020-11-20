package com.xsg.sscm.service.Impl;

import com.xsg.sscm.dao.AdminRelationDao;
import com.xsg.sscm.mapper.UAdminMapper;
import com.xsg.sscm.model.UAdmin;
import com.xsg.sscm.model.UAdminExample;
import com.xsg.sscm.model.UFontMenu;
import com.xsg.sscm.model.URole;
import com.xsg.sscm.po.ApiPO;
import com.xsg.sscm.po.FontMenuPO;
import com.xsg.sscm.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.service.Impl
 * @author: xsg
 * @date: 2020/9/21
 **/
@Service
public class SecurityServiceImp implements SecurityService {

    @Autowired
    private UAdminMapper uAdminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminRelationDao adminRelationDao;

    @Override
    public boolean CheckLogin(String username, String password) throws Exception {
        UAdminExample uAdminExample = new UAdminExample();
        uAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UAdmin> uAdmins = uAdminMapper.selectByExample(uAdminExample);
        if(uAdmins.size() == 0 || uAdmins == null){
            throw new Exception("账号不存在！！！");
        }else{
            String encodepassword = uAdmins.get(0).getPassword();
            if(!passwordEncoder.matches(password,encodepassword)){
                throw  new Exception("密码错误！！！");
            }else{
                return true;
            }
        }
    }

    @Override
    public UAdmin GetUserByUsername(String username) {
        UAdminExample uAdminExample = new UAdminExample();
        uAdminExample.createCriteria().andUsernameEqualTo(username);
        List<UAdmin> uAdmins = uAdminMapper.selectByExample(uAdminExample);
        if(uAdmins.size() > 0 || uAdmins != null){
            return uAdmins.get(0);
        }
        return null;
    }

    @Override
    public List<FontMenuPO> getMenusByUserName(String username) {
        return adminRelationDao.getMenusByUserName(username);
    }

    @Override
    public int updateLoginTime(Long id, Date date) {
        UAdmin uAdmin = new UAdmin();
        uAdmin.setId(id);
        uAdmin.setLoginTime(date);
        return uAdminMapper.updateByPrimaryKeySelective(uAdmin);
    }

    @Override
    public List<URole> getRolesByUserID(long id) {
        return adminRelationDao.getRolesByUserID(id);
    }



    @Override
    public List<ApiPO> getApiUrlByUserName(String username) {
        return adminRelationDao.getApiUrlByUserName(username);
    }

}
