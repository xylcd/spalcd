package com.mindspa.spa.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *登录跳转和首页
 */
@Controller
public class loginController {
    @GetMapping("/")
    public String index() {
        return "login";
    }
        public String login() {
            return "login";
        }
    @RequestMapping("/index")
    public String indexc() {
        return "index";
    }

}
