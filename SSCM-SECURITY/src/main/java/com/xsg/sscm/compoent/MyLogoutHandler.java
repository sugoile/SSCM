package com.xsg.sscm.compoent;


import com.xsg.sscm.util.BeJsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @des:    登出处理器
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/15
 **/
@Component
public class MyLogoutHandler extends BeJsonUtil implements LogoutHandler {

    @Value("${jwt.header}")
    private String header;

    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {
        String headerToken = request.getHeader(header);
        //System.out.println("logout header Token = " + headerToken);
        //System.out.println("logout request getMethod = " + request.getMethod());
        //
        if (!StringUtils.isEmpty(headerToken)) {
            //postMan测试时，自动假如的前缀，要去掉。
            String token = headerToken.replace("Bearer ", "").trim();
           // System.out.println("authentication = " + authentication);
            SecurityContextHolder.clearContext();

            //需要让token失效
        }

    }
}
