package com.sm.user.dao.impl;

import com.sm.common.dao.impl.HibernateGenericDaoImpl;
import com.sm.user.dao.UserDao;
import com.sm.user.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Newbody on 2016/3/1.
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateGenericDaoImpl<User, String> implements UserDao {
}
