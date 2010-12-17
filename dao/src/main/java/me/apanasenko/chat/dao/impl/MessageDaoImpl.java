package me.apanasenko.chat.dao.impl;

import me.apanasenko.chat.dao.MessageDao;
import me.apanasenko.chat.model.MessageEntity;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
public class MessageDaoImpl extends BasicDaoImpl<MessageEntity> implements MessageDao {
    public MessageDaoImpl(Class<MessageEntity> domainEntityClass) {
        super(domainEntityClass);
    }
}
