package com.xsg.sscm.compoent;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.util.BeJsonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @des:    登陆成功处理器
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/14
 **/
@Component
public class MyAuthenticationFailureHandler extends BeJsonUtil implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        REData<Object> failed = REData.failed("登陆失败！！！" + e.getMessage());
        this.WriteJSON(request, response, failed);
    }
}
