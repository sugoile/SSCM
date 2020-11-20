package com.xsg.sscm.service.auth;

import com.xsg.sscm.model.UAdmin;
import com.xsg.sscm.model.URole;
import com.xsg.sscm.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @des: 实现UserDetailsService接口来查询用户拥有的权限
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/11
 **/
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SecurityService securityService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UAdmin uAdmin = securityService.GetUserByUsername(username);
        if(uAdmin == null ){
            throw  new UsernameNotFoundException(username + "用户不存在！！");
        }else{
            //该用户的角色
            List<URole> roles = securityService.getRolesByUserID(uAdmin.getId());
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for(URole role : roles){
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            return new MyUserDetails(uAdmin.getId(), uAdmin.getUsername(), uAdmin.getPassword(), uAdmin.getStatus(), authorities);
        }
    }
}
