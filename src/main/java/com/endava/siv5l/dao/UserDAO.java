package com.endava.siv5l.dao;

import com.endava.siv5l.model.User;

import java.util.List;

/**
 * Created by siv5l on 4/3/16.
 */
public interface UserDAO {
    public void add(User user);
    public void edit(User user);
    public void delete(long userId);
    public User getUser(long userId);
    public List getAllUsers();
    public User getByUsername(String username);
    public List getUsersJoinCategoryLocation(String locatie, String categorie);
    public List getUsersJoinCategory(String category);
    public List getUsersJoinLocation(String location);
}
