package com.endava.siv5l.controller;

import com.endava.siv5l.model.Category;
import com.endava.siv5l.model.User;
import com.endava.siv5l.service.CategoryService;
import com.endava.siv5l.service.ListOfCategories;
import com.endava.siv5l.service.MessageMap;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by siv5l on 4/3/16.
 */

@Controller
@SessionAttributes("userAccount")
public class SignInController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageMap messageMap;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String checkAccount(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model){

        ArrayList<String> errors = new ArrayList<String>();

        if(username.equals("") || password.equals("")){
            errors.add("Nu este inserat username sau parola");
            errors.add("ads ad asdas ");
            model.addAttribute("errors",errors);
            return "signin";
        }
        User user = userService.getByUsername(username);
        System.out.println();
        if (user != null && password.equals( user.getPassword())){
            model.addAttribute("userAccount",user);


            // adaug useru in MAP
            messageMap.getMap().put(username,new ArrayList<String>());




            return "logged";
        }
        else {
            errors.add("nu exista asa user sau parola nu este corect");
            model.addAttribute("errors", errors);
            return "signin";
        }
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String checkAcount(){
        return "logged";
    }

}
