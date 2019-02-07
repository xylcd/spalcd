package com.mindspa.spa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *s所有页面跳转入口
 */
@Controller
public class EntranceController {
    @RequestMapping("/memberCustomer")
    public String indexc() {
        return "memberCustomer";
    }
}
