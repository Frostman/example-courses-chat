package me.apanasenko.chat.model;

import javax.persistence.*;

/**
 * @author Anton Panasenko
 * Date: 17.12.10
 */
@Entity
@Table(name = "user_table")
public class UserEntity extends BasicEntity {
    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "user_name")
    private String userName;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
