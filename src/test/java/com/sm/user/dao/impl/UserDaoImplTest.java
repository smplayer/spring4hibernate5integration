package com.sm.user.dao.impl;

import com.sm.EventPublisher;
import com.sm.user.UserCreationEvent;
import com.sm.user.UserModificationEvent;
import com.sm.user.dao.UserDao;
import com.sm.user.entity.User;
import config.ApplicationConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Newbody on 2016/3/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
//@TransactionConfiguration(defaultRollback = true) 该注解已经被@Rollback和@Commit代替
/*
 * 不添加@Transactional会导致如下异常:
 * org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread
 */
@Transactional
/*
 * @Commit可以用@Rollback(false)代替,但是两者不能同时使用
 * doc: http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/annotation/Commit.html
 * @Commit is a test annotation that is used to indicate that a test-managed transaction should be committed after the test method has completed
 */
@Commit
public class UserDaoImplTest {

//    private SessionFactory sessionFactory;

    @Autowired
    private EventPublisher eventPublisher;

    @Resource(name = "userDao")
    private UserDao userDao;

    private String userId;

    @Before
    public void setUp() throws Exception {
        //Hibernate 5.0.2Final与之前创建方法不同，之前创建方法会报各种错误，查官方文档
        // 注册服务
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        // 创建会话工厂
//        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void saveTest(){
        User user = new User();
        user.setUsername("username1");
        user.setPassword("password1");
        userDao.save(user);
        userId = user.getId();
        eventPublisher.publishEvent(new UserCreationEvent("user1 created"));
        eventPublisher.publishEvent(new UserModificationEvent("user1 modified"));
    }

    @After
    public void after(){
        User user = userDao.getById(userId);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}