package com.endava.siv5l.service.impl;

import com.endava.siv5l.dao.UserDao;
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
    private UserDao userDao;

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional
    public void delete(int userId) {
        userDao.delete(userId);
    }

    @Transactional
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }

    @Transactional
    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }


}
