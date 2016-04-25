package com.endava.siv5l.dao;

import com.endava.siv5l.model.Category;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
public interface CategoryDAO {
    public void add(Category category);
    public void edit(Category category);
    public void delete(int categoryId);
    public Category getCategory(int categoryId);
    public List getAllCategories();
    public Category getByName(String name);
}
