package com.xxx.springsecuritydemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailesServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder pw;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("执行了loadUserByUsername方法");
        //1.根据客户端用户名判断用户是否存在，不存在则抛出异常UsernameNotFoundException
        if(!"admin".equals(username)){
            throw  new UsernameNotFoundException("用户名不存在！");
        }
        //2.把查询出来的密码（注册时就已经进行加密）进行解析，或者直接把密码放入构造方法
        String passward = pw.encode("123");
        return new User(username,passward, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }

}
