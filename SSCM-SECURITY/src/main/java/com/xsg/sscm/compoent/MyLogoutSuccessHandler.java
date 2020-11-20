package com.xsg.sscm.compoent;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.util.BeJsonUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @des:  成功登出返回的数据
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/15
 **/
@Component
public class MyLogoutSuccessHandler extends BeJsonUtil implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        //System.out.println("退出成功。。。。。。");
        super.WriteJSON(request, response, REData.success("成功登出"));
    }
}
