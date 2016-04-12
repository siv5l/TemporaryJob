package com.endava.siv5l.dao.impl;

import com.endava.siv5l.dao.CategoryDAO;
import com.endava.siv5l.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Category category) {
        sessionFactory.getCurrentSession().save(category);
    }

    @Override
    public void edit(Category category) {
        sessionFactory.getCurrentSession().update(category);
    }

    @Override
    public void delete(int categoryId) {
        sessionFactory.getCurrentSession().delete(getCategory(categoryId));
    }

    @Override
    public Category getCategory(int categoryId) {
        return (Category) sessionFactory.getCurrentSession().get(Category.class,categoryId) ;
    }

    @Override
    public List getAllCategories() {
        return sessionFactory.getCurrentSession().createQuery("FROM Category").list();
    }
}
