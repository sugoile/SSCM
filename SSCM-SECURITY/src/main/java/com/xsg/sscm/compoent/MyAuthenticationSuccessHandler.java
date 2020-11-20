package com.xsg.sscm.compoent;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.po.FontMenuPO;
import com.xsg.sscm.service.SecurityService;
import com.xsg.sscm.service.auth.MyUserDetails;
import com.xsg.sscm.util.BeJsonUtil;
import com.xsg.sscm.util.JwtTokenUtil;
import com.xsg.sscm.util.TokenCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.*;

/**
 * @des: 登陆成功处理器
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/14
 **/
@Component
public class MyAuthenticationSuccessHandler extends BeJsonUtil implements AuthenticationSuccessHandler {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private SecurityService securityService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //取得账号信息
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //System.out.println("userDetails = " + userDetails);
        //取token
        //好的解决方案，登录成功后token存储到数据库中
        //只要token还在过期内，不需要每次重新生成
        //先去缓存中找(redis缓存也是一个不错的解决方案)
        String token = TokenCache.getTokenFromCache(userDetails.getUsername());
        if (token == null) {
            //System.out.println("初次登录，token还没有，生成新token。。。。。。");
            token = jwtTokenUtil.generateToken(userDetails);
            //把新的token存储到缓存中
            TokenCache.setToken(userDetails.getUsername(), token);
        }

        //加载前端菜单
        List<FontMenuPO> menus = securityService.getMenusByUserName(userDetails.getUsername());
        String nickName = securityService.GetUserByUsername(userDetails.getUsername()).getNickName();
        Map<String, Object> data = new HashMap<>();
        data.put("Username", userDetails.getUsername());
        List<String> authorities = new ArrayList<>();
        for (GrantedAuthority a : userDetails.getAuthorities()) {
            authorities.add(a + "");
        }
        data.put("ID", userDetails.getId());
        data.put("Authorities", authorities);
        data.put("menus",menus);
        data.put("token", token);
        data.put("nickName", nickName);

        //登录时间记录
        Date login_time = new Date();
        securityService.updateLoginTime(userDetails.getId(), login_time);

        REData<Map<String, Object>> success = REData.success(data);
        this.WriteJSON(request, response, success);
    }
}
