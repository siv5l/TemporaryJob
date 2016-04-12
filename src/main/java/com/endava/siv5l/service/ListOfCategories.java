package com.endava.siv5l.service;

import com.endava.siv5l.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by siv5l on 4/11/16.
 */
@Component
@Scope("session")
public class ListOfCategories {

    private ArrayList <Category> categories;

    public ListOfCategories(){}
    @Autowired
    public ListOfCategories(CategoryService categoryService) {
        this.categories = (ArrayList<Category>) categoryService.getAllCategories();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
