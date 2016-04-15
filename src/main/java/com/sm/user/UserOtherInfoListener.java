package com.sm.user;

import com.sm.user.UserCreationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Newbody on 2016/3/14.
 */
@Component
public class UserOtherInfoListener implements ApplicationListener<UserCreationEvent> {
    @Override
    public void onApplicationEvent(UserCreationEvent event) {
        System.out.println("initial user's other info after user created");
    }
}
