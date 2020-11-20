package com.xsg.sscm.compoent;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.util.BeJsonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @des: 身份验证登录失败(token错误)
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/11
 **/
@Component
public class MyAuthenticationEntryPoint extends BeJsonUtil implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

//        response.setContentType("application/json;charset=UTF-8");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Method", "POST,GET");
//        response.getWriter().println(JSONUtil.parse(REData.NOTFINDFILE("身份验证失败！" + authException.getMessage())));
//        response.getWriter().flush();
        REData<Object> notfindfile = REData.UNAUTHORIZED("token验证失败！！！" + authException.getMessage());
        this.WriteJSON(request, response, notfindfile);
        
    }
}
