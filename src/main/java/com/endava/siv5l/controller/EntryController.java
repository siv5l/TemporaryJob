package com.endava.siv5l.controller;


import com.endava.siv5l.service.CategoryService;
import com.endava.siv5l.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpSession;

/**
 * Created by siv5l on 4/11/16.
 */
@Controller

@SessionAttributes( value = {"categories", "locations"})

public class EntryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LocationService locationService;



    @RequestMapping("/temporaryjob")
    public String onEntryPage(HttpSession session){


        if((session.getAttribute("categories") == null) & (session.getAttribute("locations") == null) ) {
            session.setAttribute("categories",categoryService.getAllCategories());
            session.setAttribute("locations",locationService.getAllLocations());
        }

        try{
            if(!session.getAttribute("userAccount").equals(null)){
                return "logged";
            }
        }
        catch (NullPointerException e){
            return "signin";
        }
        return "logged";
    }
}
