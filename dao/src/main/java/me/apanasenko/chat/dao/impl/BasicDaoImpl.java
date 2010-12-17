package me.apanasenko.chat.dao.impl;

import me.apanasenko.chat.dao.BasicDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
public class BasicDaoImpl<T> extends HibernateDaoSupport implements BasicDao<T> {
    private final Class<T> domainEntityClass;

    public BasicDaoImpl(Class<T> domainEntityClass) {
        this.domainEntityClass = domainEntityClass;
    }

    public final Class<T> getDomainEntityClass() {
        return this.domainEntityClass;
    }

    public final T makePersistent(final T domainObject) {
        getHibernateTemplate().saveOrUpdate(domainObject);
        return domainObject;
    }

    public final void makeTransient(final T domainObject) {
        getHibernateTemplate().delete(domainObject);
    }

    @SuppressWarnings("unchecked")
    public T findById(long id) {
        return (T) getHibernateTemplate().get(getDomainEntityClass(), id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return (List<T>) getHibernateTemplate().loadAll(getDomainEntityClass());
    }
}