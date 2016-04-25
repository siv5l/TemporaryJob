package com.endava.siv5l.service.impl;

import com.endava.siv5l.dao.CategoryDAO;
import com.endava.siv5l.model.Category;
import com.endava.siv5l.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;


    @Transactional
    public void add(Category category) {
        categoryDAO.add(category);
    }

    @Transactional
    public void edit(Category category) {
        categoryDAO.edit(category);
    }

    @Transactional
    public void delete(int categoryId) {
        categoryDAO.delete(categoryId);
    }

    @Transactional
    public Category getCategory(int categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    @Transactional
    public List getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Transactional
    public Category getByName(String name) {
        return categoryDAO.getByName(name);
    }
}
