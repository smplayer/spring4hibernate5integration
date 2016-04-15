package com.sm.common.query;

import com.sm.common.Base;

/**
 * Created by Newbody on 2016/2/26.
 */
public class Order extends Base {
    private String propertyName;
    private OrderMode orderMode = OrderMode.ASC;

    private Order() {
    }

    private Order(String propertyName, OrderMode orderMode) {
        this.propertyName = propertyName;
        this.orderMode = orderMode;
    }

    public static Order asc(String propertyName){
        return new Order(propertyName, OrderMode.ASC);
    }

    public static Order desc(String propertyName){
        return new Order(propertyName, OrderMode.DESC);
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public OrderMode getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(OrderMode orderMode) {
        this.orderMode = orderMode;
    }
}
