package com.xsg.sscm.compoent;

import org.springframework.security.core.AuthenticationException;

/**
 * @des: 自定义异常类，继承AuthenticationException
 *       在有throws AuthenticationException方法上捕获
 *       方式：throw new  MyAuthenticationException
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/14
 **/
public class MyAuthenticationException extends AuthenticationException {
    public MyAuthenticationException(String msg) {
        super(msg);
    }
}
