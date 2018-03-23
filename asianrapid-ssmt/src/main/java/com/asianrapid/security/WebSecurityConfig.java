package com.asianrapid.security;

import com.asianrapid.commons.MD5Util;
import com.asianrapid.security.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration //必须加这个注解，用于生成一个配置类，
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true) //启用Security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserService customUserService;

    /**
     * 配置.忽略的静态文件，不加的话，登录之前页面的css,js不能正常使用，得登录之后才能正常.
     */

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 忽略URL
        web.ignoring().antMatchers("/lang/*.json",
                "/**/*.css", "/**/*.js", "/**/*.map", "/**/*.html",
                "/**/*.png", "/**/*.woff", "/**/*.ttf", "/**/*.svg", "/**/*.woff2");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(customUserService).passwordEncoder(new PasswordEncoder(){
            //使用MD5获取加密之后的密码
            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String)rawPassword);
            }
            //验证密码
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String)rawPassword));
            }});
        //user Details Service验证
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭 CSRF 保护：
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/static/**",
                        "/view/login", "/view/index", "/view/register", "/view/insert").permitAll()  //首页任意访问
                .anyRequest().authenticated() // //其他所有资源都需要认证，登陆后才能访问
                .and()
                .formLogin()
                .loginPage("/view/login").loginProcessingUrl("/login")
                .successHandler(new LoginHandler())
//                .defaultSuccessUrl("/view/home", true)//登录成功之后跳转首页
                .failureUrl("/view/login?error") //登录失败 返回error
                .permitAll() // 登录页面用户任意访问
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/view/login").permitAll(); // 注销行为任意访问
    }

}