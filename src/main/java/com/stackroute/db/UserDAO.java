package com.stackroute.db;

import java.util.List;

import javax.transaction.Transactional;

import com.stackroute.controller.User;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public class UserDAO implements UserD {

    @Autowired
    private SessionFactory sessionFactory;


    public UserDAO(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }


    public void saveUser(User user) {
        try {

            sessionFactory.getCurrentSession().save(user);

        } catch (Exception exception) {
            exception.printStackTrace();

        }
    }
    public String getUserByName(String username) {

        User user=sessionFactory.getCurrentSession().load(User.class,username);

        Hibernate.initialize(user);
        return user.getUsername();
    }
}
