package com.endava.siv5l.controller;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.messaging.MessageMap;
import com.endava.siv5l.service.UserService;
import com.endava.siv5l.service.validation.LoginValidation;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

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
    public String checkAccount( @RequestParam("username") String username, @RequestParam("password") String password,
                                @Valid @ModelAttribute("loginValidation") LoginValidation loginValidation,
                                BindingResult result,
                                ModelMap model){
        if(result.hasErrors()){
            return "signin";
        }

        try{
            // adaug useru in MAP pentru chat
            User user = userService.getByUsername(username);
            if((user != null) && (password.equals(user.getPassword()))){
                messageMap.getMap().put(username,new ArrayList<String>());
                model.addAttribute("userAccount",user);
            }
            else {
                model.addAttribute("unlogged", "nu esti logat");
            }
            return "logged";
        }
        catch(HibernateException hibernateException){
            hibernateException.printStackTrace();
            return "signin";
        }
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String checkAcount(){
        return "logged";
    }

}
