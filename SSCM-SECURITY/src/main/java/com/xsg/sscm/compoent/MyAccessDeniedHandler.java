package com.xsg.sscm.compoent;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.util.BeJsonUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @des: 权限校验处理器(权限不足)
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/11
 **/
@Component
public class MyAccessDeniedHandler extends BeJsonUtil implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
//        response.setContentType("application/json;charset=UTF-8");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Method", "POST,GET");
//        response.getWriter().println(JSONUtil.parse(REData.FORBIDDEN("该访问权限不足！" + authException.getMessage())));
//        response.getWriter().flush();
        REData<Object> forbidden = REData.FORBIDDEN("该访问权限不足！！！" + authException.getMessage());
        this.WriteJSON(request, response, forbidden);
    }
}
