package com.endava.siv5l.controller;

import com.endava.siv5l.model.Category;
import com.endava.siv5l.model.Location;
import com.endava.siv5l.service.CategoryService;
import com.endava.siv5l.service.ListOfCategories;
import com.endava.siv5l.service.LocationService;
import com.endava.siv5l.service.MessageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by siv5l on 4/11/16.
 */
@Controller
/*@Scope("request")*/
@SessionAttributes("categories")
public class EntryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LocationService locationService;
    /*@Autowired
    private ListOfCategories listOfCategories;*/


    @RequestMapping("/temporaryjob")
    public String onEntryPage(HttpSession session){
        if((session.getAttribute("categories") == null) & (session.getAttribute("locations") == null) ) {
            session.setAttribute("categories",categoryService.getAllCategories());
            System.out.println("1");
            session.setAttribute("locations",locationService.getAllLocations());
        }
        System.out.println("2");
        return "signin";
    }
}
