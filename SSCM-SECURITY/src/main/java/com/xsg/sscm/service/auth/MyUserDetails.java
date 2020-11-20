package com.xsg.sscm.service.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @des:
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/14
 **/
@Component
public class MyUserDetails implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private Integer state;

    private Collection<? extends GrantedAuthority> authorities;

    public MyUserDetails() {
    }

    public MyUserDetails(Long id, String username, String password, Integer state, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.state = state;
        this.authorities = authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Integer getState() {
        return state;
    }

    public Long getId() {
        return id;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }   //账号是否未过期

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }      //账号是否未锁定

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }       //密码是否未过期

    @Override
    public boolean isEnabled() {
        return state == 1? true : false;
    }         //是否激活

    @Override
    public String toString() {
        return "JwtUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", authorities=" + authorities +
                '}';
    }
}
