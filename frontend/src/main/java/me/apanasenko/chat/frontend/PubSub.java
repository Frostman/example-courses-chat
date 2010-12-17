package me.apanasenko.chat.frontend;

import me.apanasenko.chat.dao.MessageDao;
import me.apanasenko.chat.dao.RoomDao;
import me.apanasenko.chat.dao.UserDao;
import me.apanasenko.chat.model.MessageEntity;
import me.apanasenko.chat.model.RoomEntity;
import me.apanasenko.chat.model.UserEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.atmosphere.annotation.Broadcast;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.jersey.Broadcastable;
import org.atmosphere.jersey.SuspendResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */

@Component
@Path("/pubsub/{topic}/{name}")
@Produces("text/html;charset=utf-8")
public class PubSub {
    private static final Log logger = LogFactory.getLog(PubSub.class);
    private static UserDao userDao;
    private static MessageDao messageDao;
    private static RoomDao roomDao;
    private @PathParam("topic") Broadcaster topic;

    public @GET SuspendResponse<String> subscribe(@Context HttpServletRequest req,
                                                  @PathParam("name") String name) {
        UserEntity user = userDao.findByUserName(name);
        if (user == null) {
            user = new UserEntity();
            user.setUserName(name);
            userDao.makePersistent(user);
        }

        RoomEntity roomEntity = roomDao.findByName(topic.getID());
        if (roomEntity == null) {
            roomEntity = new RoomEntity();
            roomEntity.setRoomName(topic.getID());
            roomDao.makePersistent(roomEntity);
        }

        req.getSession().setAttribute("user_id", user.getUserId());
        req.getSession().setAttribute("room_id", roomEntity.getRoomId());

        return new SuspendResponse.SuspendResponseBuilder<String>()
                .broadcaster(topic)
                .outputComments(true)
                .addListener(new ActionLogger())
                .build();
    }

    @Broadcast
    public @POST Broadcastable publish(@Context HttpServletRequest req,
                                       @FormParam("name") String name,
                                       @FormParam("message") String message,
                                       @FormParam("transport") String transport) {
        UserEntity user = userDao.findById((Long) req.getSession().getAttribute("user_id"));
        RoomEntity room = roomDao.findById((Long) req.getSession().getAttribute("room_id"));
        MessageEntity entity = new MessageEntity();
        entity.setMessage(message);
        entity.setDate(System.currentTimeMillis());
        entity.setRoomId(room.getRoomId());
        entity.setUserId(user.getUserId());
        messageDao.makePersistent(entity);
        logger.debug("Room: " + room.getRoomName() + " " + name + ": " + message + " " + transport);
        return new Broadcastable(name + ": " + message, "", topic);
    }

    public void setUserDao(UserDao userDao) {
        PubSub.userDao = userDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        PubSub.messageDao = messageDao;
    }

    public void setRoomDao(RoomDao roomDao) {
        PubSub.roomDao = roomDao;
    }
}
