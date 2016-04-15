package com.sm.user;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Newbody on 2016/3/14.
 */
public class UserModificationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public UserModificationEvent(Object source) {
        super(source);
    }
}
