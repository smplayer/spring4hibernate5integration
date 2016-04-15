package com.sm.common.dao.impl;

import com.sm.common.Base;
import com.sm.common.dao.GenericDao;
import com.sm.common.query.PageHandler;
import com.sm.common.query.Query;
import com.sm.common.query.hibernate.QueryForHibernate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

/**
 * Created by Newbody on 2016/2/28.
 */
public class HibernateGenericDaoImpl<E, PK extends Serializable> extends Base implements GenericDao<E, PK> {
    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;
    protected Class<E> entityClass;

    public HibernateGenericDaoImpl() {
        Class c = getClass();
        ParameterizedType ptype = null;
        do { // 遍历所有超类，直到找泛型定义
            try {
                ptype = (ParameterizedType) c.getGenericSuperclass();
            } catch (Exception e) {
            }
            c = c.getSuperclass();
        } while (ptype == null && c != null);
        if (ptype == null) {
            System.out.println("子类中没有定义泛型的具体类型");
        } else {
            this.entityClass = (Class<E>) ptype.getActualTypeArguments()[0];
        }
    }

    @Override
    public void save(E entity) {
        getSession().save(entity);
    }

    @Override
    public void save(Collection<E> entities) {
        for (E e : entities){
            this.save(e);
        }
    }

    @Override
    public void delete(PK id) {
        Session session = getSession();
        E e = getById(id);
        session.delete(e);
    }

    @Override
    public void update(E entity) {
        getSession().update(entity);
    }

    @Override
    public void update(Collection<E> entities) {
        for (E e : entities) {
            this.update(e);
        }
    }

    @Override
    public E getById(PK id) {
        return getSession().get(getEntityClass(), id);
    }

    @Override
    public E get(Query query) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        QueryForHibernate qfh = (QueryForHibernate) query;
        for (Criterion criterion : qfh.getCriteriaList()){
            criteria.add(criterion);
        }
        return (E) criteria.uniqueResult();
    }

    @Override
    public List<E> getList() {
        return getSession().createCriteria(getEntityClass()).list();
    }

    @Override
    public List<E> getList(Query query) {
        Criteria criteria = getSession().createCriteria(getEntityClass());
        QueryForHibernate qfh = (QueryForHibernate) query;
        for (Criterion criterion : qfh.getCriteriaList()){
            criteria.add(criterion);
        }
        return criteria.list();
    }

    @Override
    public PageHandler getPage(Query query) {
        PageHandler page = new PageHandler();
        page.setPageIndex(query.getPageIndex());
        page.setPageSize(query.getPageSize());

        Criteria criteria = getSession().createCriteria(getEntityClass());
        QueryForHibernate qfh = (QueryForHibernate) query;
        for (Criterion criterion : qfh.getCriteriaList()){
            criteria.add(criterion);
        }
        criteria.setFirstResult(query.getDataIndex().intValue());
        criteria.setMaxResults(query.getPageSize());
        page.setDataList(criteria.list());

        criteria.setProjection(Projections.rowCount());
        page.setDataQuantity((Long)criteria.uniqueResult());

        return page;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Class<E> getEntityClass() {
        return this.entityClass;
    }

    public void setEntityClass(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }
}
