package com.endava.siv5l.controller;


import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by siv5l on 4/11/16.
 */
@Controller


public class EntryController {
    @Autowired
    private UserService userService;

    @RequestMapping("/temporaryjob")
    public String onEntryPage(HttpSession session){

        try{
            if(!session.getAttribute("userAccount").equals(null)){
                return "log/logged";
            }
            else {
                System.out.println("1");
                return "log/unlogged";
            }
        }
        catch (NullPointerException e){
            System.out.println("2");
            return "log/unlogged";
        }
    }

    /*@RequestMapping(value = "*//*", method = RequestMethod.GET)
    public String home(ModelMap model){
        return "home";
    }*/
}
