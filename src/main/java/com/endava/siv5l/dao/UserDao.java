package com.endava.siv5l.dao;

import com.endava.siv5l.model.User;

import java.util.List;

/**
 * Created by siv5l on 4/3/16.
 */
public interface UserDao {
    public void add(User user);
    public void edit(User user);
    public void delete(int userId);
    public User getUser(int userId);
    public List getAllUsers();
    public User getByUsername(String username);
}
