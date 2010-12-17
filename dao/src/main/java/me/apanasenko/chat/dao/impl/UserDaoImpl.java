package me.apanasenko.chat.dao.impl;

import me.apanasenko.chat.dao.BasicDao;
import me.apanasenko.chat.dao.UserDao;
import me.apanasenko.chat.model.UserEntity;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
public class UserDaoImpl extends BasicDaoImpl<UserEntity> implements UserDao {
    public UserDaoImpl(Class<UserEntity> domainEntityClass) {
        super(domainEntityClass);
    }
}
