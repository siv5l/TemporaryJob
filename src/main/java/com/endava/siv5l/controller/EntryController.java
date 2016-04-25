package com.endava.siv5l.controller;


import com.endava.siv5l.model.Location;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.CategoryService;
import com.endava.siv5l.service.LocationService;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpSession;

/**
 * Created by siv5l on 4/11/16.
 */
@Controller


public class EntryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LocationService locationService;

    @Autowired
    private UserService userService;

    @RequestMapping("/temporaryjob")
    public String onEntryPage(HttpSession session){

        try{
            if(!session.getAttribute("userAccount").equals(null)){
                return "logged";
            }
            else {
                return "signin";
            }
        }
        catch (NullPointerException e){
            return "signin";
        }
    }
}
