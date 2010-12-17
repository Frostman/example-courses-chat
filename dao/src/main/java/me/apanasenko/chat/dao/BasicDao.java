package me.apanasenko.chat.dao;

import java.util.List;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */

public interface BasicDao<T> {
    Class<T> getDomainEntityClass();
    T makePersistent(T domainObject);
    void makeTransient(T domainObject);
    T findById(long id);
    List<T> findAll();
}
