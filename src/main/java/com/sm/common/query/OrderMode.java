package com.sm.common.query;

import com.sm.common.Base;

/**
 * Created by Newbody on 2016/2/26.
 */
public enum OrderMode {
    ASC("ASC"), DESC("DESC");

    private final String value;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    OrderMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
