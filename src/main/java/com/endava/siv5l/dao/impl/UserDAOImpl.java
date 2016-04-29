package com.endava.siv5l.dao.impl;

import com.endava.siv5l.dao.UserDAO;
import com.endava.siv5l.model.User;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siv5l on 4/3/16.
 */
@Repository
public class UserDAOImpl implements UserDAO {

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
    public void delete(long userId) {
        sessionFactory.getCurrentSession().delete(getUser(userId));
    }

    @Override
    public User getUser(long userId) {
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

    @Override
    public List getUsersJoinCategoryLocation(String locatie, String categorie) {
        return sessionFactory.getCurrentSession().createSQLQuery("SELECT User.user_id, User.password, User.username, User.first_name, User.last_name, User.date_of_birth, User.phone, User.email\n" +
                "FROM User\n" +
                "INNER JOIN User_Category ON User.user_id = User_Category.user_id\n" +
                "INNER JOIN Category ON User_Category.category_id = Category.category_id\n" +
                "INNER JOIN User_Location ON User.user_id = User_Location.user_id\n" +
                "INNER JOIN Location ON User_Location.location_id = Location.location_id\n" +
                "WHERE Location.name = :locatie AND Category.name = :categorie").addEntity(User.class).setParameter("locatie", locatie).setParameter("categorie",categorie).list();
    }

    @Override
    public List getUsersJoinCategory(String category) {
        return sessionFactory.getCurrentSession().createQuery("from User u join u.userCategories c where c.name =:category").setParameter("category",category).list();
    }

    public List getUsersJoinLocation(String location) {
        return sessionFactory.getCurrentSession().createQuery("from User u join u.userLocations l where l.name =:location").setParameter("location",location).list();
    }
}
