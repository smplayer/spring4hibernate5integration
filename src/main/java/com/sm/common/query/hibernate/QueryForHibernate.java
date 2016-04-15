package com.sm.common.query.hibernate;

import com.sm.common.Base;
import com.sm.common.query.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.sm.common.config.PagingConfig.MAX_PAGE_SIZE;
import static com.sm.common.config.PagingConfig.DEFAULT_PAGE_SIZE;

/**
 * Created by Newbody on 2016/2/26.
 */
public class QueryForHibernate extends Base implements Query {
//    private List<Projection> projectionList;
    private List<Criterion> criteriaList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private Long pageIndex = 1L;
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    @Override
    public QueryForHibernate eq(String propertyName, Object value){
        this.criteriaList.add(Restrictions.eq(propertyName, value));
        return this;
    }

    @Override
    public QueryForHibernate ne(String propertyName, Object value){
        this.criteriaList.add(Restrictions.ne(propertyName, value));
        return this;
    }

    @Override
    public QueryForHibernate in(String propertyName, Collection<?> value){
        this.criteriaList.add(Restrictions.in(propertyName, value));
        return this;
    }

    @Override
    public QueryForHibernate asc(String propertyName){
        orderList.add(Order.asc(propertyName));
        return this;
    }

    @Override
    public QueryForHibernate desc(String propertyName){
        orderList.add(Order.desc(propertyName));
        return this;
    }

    @Override
    public Long getPageIndex() {
        return  1 > pageIndex ? 1 : pageIndex;
    }

    @Override
    public QueryForHibernate setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    @Override
    public Integer getPageSize() {
        return 1 > pageSize ? DEFAULT_PAGE_SIZE : MAX_PAGE_SIZE < pageSize ? MAX_PAGE_SIZE : pageSize;
    }

    @Override
    public QueryForHibernate setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public Long getDataIndex() {
        return (pageIndex - 1) * pageSize;
    }

    public List<Criterion> getCriteriaList() {
        return criteriaList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
