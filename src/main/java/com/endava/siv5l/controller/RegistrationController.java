package com.endava.siv5l.controller;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by siv5l on 4/4/16.
 */
@Controller
@SessionAttributes("userAccount")
public class RegistrationController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String inregistrare(ModelMap map){
        User user = new User();
        map.put("user",user);
        return "registration";
    }

    @RequestMapping(value = "/submitregistration", method = RequestMethod.POST)
    public String inregistrare(@ModelAttribute User user, BindingResult result,ModelMap map){
        userService.add(user);
        map.addAttribute("userAccount",user);
        return "logged";
    }

    @RequestMapping(value = "/submitregistration", method = RequestMethod.GET)
    public String loggedRegistration(ModelMap map){
        return "logged";
    }
}
