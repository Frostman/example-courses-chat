package me.apanasenko.chat.model;

import javax.persistence.*;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
@Entity
@Table(name = "message_table")
public class MessageEntity extends BasicEntity {
    @Column(name = "message_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long messageId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "room_id")
    private long roomId;

    @Column(name = "message")
    private String message;

    @Column(name = "message_date")
    private long date;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
