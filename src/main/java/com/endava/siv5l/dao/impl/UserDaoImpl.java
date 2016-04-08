package com.endava.siv5l.dao.impl;

import com.endava.siv5l.dao.UserDao;
import com.endava.siv5l.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siv5l on 4/3/16.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void edit(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int userId) {
        sessionFactory.getCurrentSession().delete(getUser(userId));
    }

    @Override
    public User getUser(int userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public User getByUsername(String userName) {
       return (User) sessionFactory.getCurrentSession().createQuery("FROM User u where u.username = :u").setParameter("u", userName).uniqueResult();
    }

}
