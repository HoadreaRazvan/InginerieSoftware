package com.example.parkinglot.entity;

import jakarta.persistence.*;

@Entity
public class UserGroup {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String userGroup;

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}