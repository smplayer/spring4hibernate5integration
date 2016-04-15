package com.sm.common.service;

import com.sm.user.dao.UserDao;
import com.sm.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Newbody on 2016/3/2.
 */

@Service
@Transactional
public class UserServiceImpl {

    @Autowired
    private UserDao userDao;

    public void save(User user){
        userDao.save(user);
//        throw new RuntimeException("don't save");
    }
}
