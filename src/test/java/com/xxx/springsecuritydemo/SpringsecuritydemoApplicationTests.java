package com.xxx.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringsecuritydemoApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder ps = new BCryptPasswordEncoder();
        String pp =  ps.encode("123");
        System.out.println(pp);
        boolean s = ps.matches("123", pp);
        System.out.println("====================");
        System.out.println(s);
    }

}
