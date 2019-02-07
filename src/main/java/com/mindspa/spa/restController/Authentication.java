package com.mindspa.spa.restController;


import com.mindspa.spa.pojo.SpaUser;
import com.mindspa.spa.serviceiml.UserServiceiml;
import com.mindspa.spa.sult.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


@RestController
public class Authentication {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserServiceiml userServiceiml;
    //登录验证入口
    @RequestMapping(value = "/authentication")
    public Result authentication(@RequestBody SpaUser spaUser, HttpSession session) {
        Result result=new Result();
        try {
            logger.info("进入登录入口......登录用户是{}",spaUser.getUserName());
            logger.info(spaUser.getUserName());
            SpaUser spaUser1 = userServiceiml.userlist(spaUser.getUserName(),spaUser.getPassword());
            if (spaUser1!=null) {

                if (spaUser1.getUserName().equals(spaUser.getUserName()) && spaUser1.getPassword().equals(spaUser.getPassword())) {
                    result.setRetCode(200);
                    result.setMessage("登录成功");
                    logger.info("登录成功");
                    session.setAttribute("user",spaUser1);
                } else {
                    logger.info("账号密码错误.!");
                    result.setRetCode(400);
                    result.setMessage("账号密码错误！");
                }
            }
        }catch (Exception e){
            logger.info("账号密码错误.!");
            logger.info(e.getMessage());
            result.setRetCode(400);
            result.setMessage("账号密码错误！");
        }
        return result ;
    }
    //登录验证入口
    @RequestMapping(value = "/userall")
    public Result user( HttpServletRequest request) {
        Result result=new Result();
        Object user = request.getSession().getAttribute("user");
        SpaUser usere = (SpaUser) user;
        result.setObject(usere);
        result.setRetCode(200);
        result.setMessage("查询成功");
        logger.info("查询成功");
        return result ;
    }
}
