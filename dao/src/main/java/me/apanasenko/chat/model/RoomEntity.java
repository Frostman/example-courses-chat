package me.apanasenko.chat.model;

import javax.persistence.*;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
@Entity
@Table(name = "room_table")
public class RoomEntity extends BasicEntity {
    @Column(name = "room_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;

    @Column(name = "room_name")
    private String roomName;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
