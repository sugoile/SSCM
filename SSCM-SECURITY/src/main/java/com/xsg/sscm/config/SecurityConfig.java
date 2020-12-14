package com.xsg.sscm.config;

import com.xsg.sscm.compoent.*;
import com.xsg.sscm.service.auth.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

/**
 * @des: security 安全认证和授权
 * @package: com.xsg.sscm.security
 * @author: xsg
 * @date: 2020/9/6
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    private MyOncePerRequestFilter myOncePerRequestFilter;
    @Autowired
    private MyLogoutHandler myLogoutHandler;
    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        //解决跨域问题。cors 预检请求放行,让Spring security 放行所有preflight request（cors 预检请求）
        httpSecurity.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

        /**让Security永远不会创建HttpSession，它不会使用HttpSession来获取SecurityContext
         * 使用的是JWT，我们这里不需要csrf
         * 基于token，所以不需要session
         */
        httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //禁用缓存
                .and().headers().cacheControl();

        /**
         * 放行静态资源
         * 这里使用的不是注解形式来显示security的权限信息，而是使用RBAC模型来动态实现security的授权等信息
         */
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                .permitAll();
        /**
         * 放行需要给学生和教师登录及使用的接口
         **/
        httpSecurity.authorizeRequests()
                .antMatchers("/SORTController/**")
                .permitAll();


        //动态访问
        httpSecurity.authorizeRequests()
                // .antMatchers(HttpMethod.POST,"/user/register").permitAll()
                .anyRequest().access("@dynamicPermission.checkPermisstion(request,authentication)");

        //拦截账号、密码。覆盖 UsernamePasswordAuthenticationFilter过滤器
        httpSecurity.addFilterAt(myUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        //拦截token，并检测。在 UsernamePasswordAuthenticationFilter 之前添加 JwtAuthenticationTokenFilter
        httpSecurity.addFilterBefore(myOncePerRequestFilter, UsernamePasswordAuthenticationFilter.class);

        //处理异常情况：认证失败和权限不足
        httpSecurity.exceptionHandling().authenticationEntryPoint(myAuthenticationEntryPoint).accessDeniedHandler(myAccessDeniedHandler);

        //登录,因为使用前端发送JSON方式进行登录，所以登录模式不设置也是可以的。
        httpSecurity.formLogin().disable();

        //退出(这里取消这个也是没问题的)
        httpSecurity.logout().addLogoutHandler(myLogoutHandler).logoutSuccessHandler(myLogoutSuccessHandler);

    }

    @Bean
    public MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
        MyUsernamePasswordAuthenticationFilter filter = new MyUsernamePasswordAuthenticationFilter();
        //成功后处理
        filter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
        //失败后处理
        filter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);

        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
