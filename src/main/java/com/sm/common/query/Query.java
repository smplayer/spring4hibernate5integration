package com.sm.common.query;

import java.util.Collection;

/**
 * Created by Newbody on 2016/2/28.
 */
public interface Query {

    public Query eq(String propertyName, Object value);

    public Query ne(String propertyName, Object value);

    public Query in(String propertyName, Collection<?> value);

    public Query asc(String propertyName);

    public Query desc(String propertyName);

    public Long getPageIndex();

    public Query setPageIndex(Long pageIndex);

    public Integer getPageSize();

    public Query setPageSize(Integer pageSize);

    public Long getDataIndex();
}
