package com.xsg.sscm.compoent;

import com.xsg.sscm.po.ApiPO;
import com.xsg.sscm.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @des:    动态授权
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/16
 **/
@Component
public class DynamicPermission {

    @Autowired
    private SecurityService securityService;

    /**
     *  判断是否有访问API的权限
     */
    public boolean checkPermisstion(HttpServletRequest request,
                                    Authentication authentication) throws AccessDeniedException {
        Object principal = authentication.getPrincipal();
        //System.out.println("DynamicPermission principal=" + principal);

        if(principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;

            //得到当前的账号
            String username = userDetails.getUsername();
            //Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
            //鉴权(API的权限)
            List<ApiPO> apis = securityService.getApiUrlByUserName(username);

            AntPathMatcher antPathMatcher = new AntPathMatcher();
            //当前访问路径
            String requestURI = request.getRequestURI();
            //提交类型
            String urlMethod = request.getMethod();

            boolean result = apis.stream().anyMatch(item ->{
                boolean hashAntPath = antPathMatcher.match(item.getApiurl(), requestURI);

                //判断请求方式是否和数据库中匹配（数据库存储：GET,POST,PUT,DELETE）
                String dbMethod = item.getApimethod();

                //处理null，万一数据库存值
                dbMethod = (dbMethod == null )? "": dbMethod;
                int hasMethod   = dbMethod.indexOf(urlMethod);

                //两者都成立，返回真，否则返回假
                return hashAntPath && (hasMethod !=-1);
            });

            if(result){
                return result;
            }else{
                throw  new AccessDeniedException("您没有访问该API的权限！");
            }
        }else{
            throw  new AccessDeniedException("不是UserDetails类型！");
        }
    }
}
