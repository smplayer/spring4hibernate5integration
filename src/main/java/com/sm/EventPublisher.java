package com.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Newbody on 2016/3/14.
 */
@Component
public class EventPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(ApplicationEvent event){
        applicationContext.publishEvent(event);
    }

}
