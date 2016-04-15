package com.sm.user;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Newbody on 2016/3/14.
 */
@Component
public class UserModificationListener implements ApplicationListener<UserModificationEvent> {
    @Override
    public void onApplicationEvent(UserModificationEvent event) {
        System.out.println("user modification event published");
    }
}
