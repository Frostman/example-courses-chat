package me.apanasenko.chat.dao.impl;

import me.apanasenko.chat.dao.BasicDao;
import me.apanasenko.chat.dao.UserDao;
import me.apanasenko.chat.model.UserEntity;

import java.util.List;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
public class UserDaoImpl extends BasicDaoImpl<UserEntity> implements UserDao {
    public UserDaoImpl(Class<UserEntity> domainEntityClass) {
        super(domainEntityClass);
    }

    @Override
    public UserEntity findByUserName(String name) {
        List<UserEntity> userList = (List<UserEntity>) getHibernateTemplate().findByNamedQuery("user.findByUserName", name);
        if (userList != null && userList.size() == 1) {
            return userList.get(0);
        }
        return null;
    }
}
