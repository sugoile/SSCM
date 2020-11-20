package com.xsg.sscm.util;

import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @des: 封装输出JSON格式的类
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/14
 **/
public class BeJsonUtil {
    public void WriteJSON(HttpServletRequest request,
                             HttpServletResponse response,
                             Object data) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        response.getWriter().println(JSONUtil.parse(data));
        response.getWriter().flush();
    }
}
