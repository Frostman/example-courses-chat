package me.apanasenko.chat.dao;

import me.apanasenko.chat.model.UserEntity;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
public interface UserDao extends BasicDao<UserEntity> {
    UserEntity findByUserName(String name);
}
