package com.stackroute.controller;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String username;

    @Column
    private String passwaord;
/*

    public User(String username, String passwaord) {
        this.username = username;
        this.passwaord = passwaord;
    }

    public User() {
    }
*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswaord() {
        return passwaord;
    }

    public void setPasswaord(String passwaord) {
        this.passwaord = passwaord;
    }
}


