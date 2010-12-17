package me.apanasenko.chat.dao.impl;

import me.apanasenko.chat.dao.RoomDao;
import me.apanasenko.chat.model.RoomEntity;

import java.util.List;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
public class RoomDaoImpl extends BasicDaoImpl<RoomEntity> implements RoomDao {
    public RoomDaoImpl(Class<RoomEntity> domainEntityClass) {
        super(domainEntityClass);
    }

    @Override
    public RoomEntity findByName(String name) {
           List<RoomEntity> roomList = (List<RoomEntity>) getHibernateTemplate().findByNamedQuery("room.findByName", name);
        if (roomList != null && roomList.size() == 1) {
            return roomList.get(0);
        }
        return null;
    }
}
