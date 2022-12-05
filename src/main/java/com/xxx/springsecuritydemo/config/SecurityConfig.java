package com.xxx.springsecuritydemo.config;


import com.xxx.springsecuritydemo.handle.MyAuthenticationFailureHandler;
import com.xxx.springsecuritydemo.handle.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单提交
        http.formLogin()
                //当发现/login时人为是登录，必须和表单提交的地址一样，去执行userDetailsServiceImpl
                .loginProcessingUrl("/login")
                //自定义登录页面
                .loginPage("/login.html")
                //登录成功后跳转页面，必须是post请求
                //.successForwardUrl("/toMain")
                //登录成功后的处理器，不能和successForwardUrl共存，
                .successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com"))
                //登录失败后跳转页面，必须是post请求
                //.failureForwardUrl("/toError");
                //登录失败后的处理器，不能和failureForwardUrl共存
                .failureHandler(new MyAuthenticationFailureHandler("/error.html"));

        //授权认证
        http.authorizeRequests()
                //error.html不需要被认证
                .antMatchers("/error.html").permitAll()
                //login.html不需要被认证
                .antMatchers("/login.html").permitAll()
                .regexMatchers("/demo").permitAll()
                //.mvcMatchers("/error.html").servletPath("/xxxx").permitAll()
                //.mvcMatchers("/demo").servletPath("/xxxx").permitAll()
                //.mvcMatchers("/login.html").servletPath("/xxxx").permitAll()
                //所有的请求都必须被认证，登录后被访问
                .anyRequest().authenticated();

        //关闭csrf防护
        http.csrf().disable();
    }
    @Bean
    public PasswordEncoder getPw(){
        return new BCryptPasswordEncoder();
    }
}
