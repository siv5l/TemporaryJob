package com.endava.siv5l.dao.impl;

import com.endava.siv5l.dao.LocationDAO;
import com.endava.siv5l.model.Location;
import com.endava.siv5l.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
@Repository
public class LocationDAOImpl implements LocationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Location location) {
        sessionFactory.getCurrentSession().save(location);
    }

    @Override
    public void edit(Location location) {
        sessionFactory.getCurrentSession().update(location);
    }

    @Override
    public void delete(int locationId) {
        sessionFactory.getCurrentSession().delete(getLocation(locationId));
    }

    @Override
    public Location getLocation(int locationId) {
        return (Location) sessionFactory.getCurrentSession().get(Location.class, locationId);
    }

    @Override
    public List getAllLocations() {
        return sessionFactory.getCurrentSession().createQuery("From Location").list();
    }

    @Override
    public Location getByName(String name) {
        return (Location) sessionFactory.getCurrentSession().createQuery("FROM Location l where l.name = :l").setParameter("l", name).uniqueResult();
    }
}
