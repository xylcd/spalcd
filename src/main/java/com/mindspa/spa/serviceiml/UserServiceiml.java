package com.mindspa.spa.serviceiml;

import com.mindspa.spa.Service.UserService;
import com.mindspa.spa.dao.userDao;
import com.mindspa.spa.pojo.SpaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceiml implements UserService {
    @Autowired
    userDao usedao;
    @Override
    public SpaUser userlist(String UserName,String password) {
        return  usedao.findByUserName(UserName,password);
    }
}
