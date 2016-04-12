package com.endava.siv5l.service.impl;

import com.endava.siv5l.dao.UserDAO;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by siv5l on 4/3/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Transactional
    public void delete(int userId) {
        userDAO.delete(userId);
    }

    @Transactional
    public User getUser(int userId) {
        return userDAO.getUser(userId);
    }

    @Transactional
    public List getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public User getByUsername(String username) {
        return userDAO.getByUsername(username);
    }


}
