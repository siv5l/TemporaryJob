package com.endava.siv5l.controller;

import com.endava.siv5l.model.Category;
import com.endava.siv5l.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by siv5l on 4/11/16.
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value="/category", method= RequestMethod.GET )
    public String toCategories(ModelMap model){
        Category category  = new Category();
        model.addAttribute("category",category);


        /*ArrayList<Category> arrayList = new ArrayList<Category>();
        arrayList = (ArrayList<Category>) categoryService.getAllCategories();
        for(Category cat: arrayList){
            System.out.println(cat.getName());
        }

        model.addAttribute("categories",arrayList);*/
        return "categoryBind";
    }

    @RequestMapping(value="/bindcategory", method = RequestMethod.POST)
        public String bindCategory(@ModelAttribute Category category, BindingResult result){
            categoryService.add(category);
        System.out.println("S-a adaugat o categorie");
            return "categoryBind";
        }
}
