package com.stackroute.db;

import com.stackroute.controller.User;

public interface UserD {

    public void saveUser(User user);

    public String getUserByName(String uname);
}
