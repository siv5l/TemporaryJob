package com.endava.siv5l.dao.impl;

import com.endava.siv5l.dao.RoleDAO;
import com.endava.siv5l.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siv5l on 5/6/16.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public void edit(Role role) {
        sessionFactory.getCurrentSession().update(role);
    }

    @Override
    public void delete(long roleId) {
        sessionFactory.getCurrentSession().delete(getRole(roleId));
    }

    @Override
    public Role getRole(long roleId) {
        return (Role) sessionFactory.getCurrentSession().get(Role.class,roleId);
    }

    @Override
    public List<Role> getAllRoles() {
        return sessionFactory.getCurrentSession().createQuery("from Role").list();
    }
}
