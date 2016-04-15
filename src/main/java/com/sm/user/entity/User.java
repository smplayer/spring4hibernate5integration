package com.sm.user.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Newbody on 2016/3/1.
 */
@Entity
@Table(name = "sm_tb_user")
public class User {
    private String id;
    private String username;
    private String password;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GenericGenerator(name="systemUUID",strategy="uuid")
    @GeneratedValue(generator="systemUUID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
