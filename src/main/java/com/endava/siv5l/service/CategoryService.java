package com.endava.siv5l.service;

import com.endava.siv5l.model.Category;

import java.util.List;

/**
 * Created by siv5l on 4/11/16.
 */
public interface CategoryService {
    public void add(Category category);
    public void edit(Category category);
    public void delete(int categoryId);
    public Category getCategory(int categoryId);
    public List<Category> getAllCategories();
    public Category getByName(String name);
}
