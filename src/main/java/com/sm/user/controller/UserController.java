package com.sm.user.controller;

import com.sm.common.Base;
import com.sm.common.service.UserServiceImpl;
import com.sm.user.dao.UserDao;
import com.sm.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Newbody on 2016/3/1.
 */
@Controller
public class UserController extends Base {


//    @Resource(name = "userDao")
    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping("user/test")
    public String userTest(){
        User user = new User();
        user.setUsername("username1");
        user.setPassword("password1");
        userService.save(user);

        return "test";
    }

}
