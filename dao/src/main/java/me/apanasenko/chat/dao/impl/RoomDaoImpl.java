package me.apanasenko.chat.dao.impl;

import me.apanasenko.chat.dao.RoomDao;
import me.apanasenko.chat.model.RoomEntity;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
public class RoomDaoImpl extends BasicDaoImpl<RoomEntity> implements RoomDao {
    public RoomDaoImpl(Class<RoomEntity> domainEntityClass) {
        super(domainEntityClass);
    }
}
