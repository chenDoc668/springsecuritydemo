package com.xxx.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    /*
    * 登陆方法
    * */
    @RequestMapping ("login")
    public String login(){
        System.out.println("执行登录方法");
        return "redirect:login.html";
    }


    /*
     * 页面跳转
     * */
    @RequestMapping ("toMain")
    public String toMain(){
        return "redirect:main.html";
    }

    /*
     * 页面跳转
     * */
    @RequestMapping ("toError")
    public String toError(){
        return "redirect:error.html";
    }

    /*
     * 页面跳转
     * */
    @GetMapping("demo")
    @ResponseBody
    public String demo(){
        return "demo";
    }
}
