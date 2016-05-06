package com.endava.siv5l.controller;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.messaging.Message;
import com.endava.siv5l.service.messaging.MessageMap;
import com.endava.siv5l.service.UserService;
import com.endava.siv5l.service.validation.LoginValidation;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.security.Principal;

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


    @RequestMapping(value = "/signin" , method = RequestMethod.GET /*,method = RequestMethod.POST*/)
    public String checkAccount(@Valid @ModelAttribute("loginValidation") LoginValidation loginValidation,
                                BindingResult result, Principal principal,
                                ModelMap model){

        if(result.hasErrors()){
            return "log/login";
        }
        try{
            // adaug useru in MAP pentru chat
            User user = userService.getByUsername(loginValidation.getUsername());
           /* User user = userService.getByUsername(principal.getName());*/
            if((user != null) && (loginValidation.getPassword().equals(user.getPassword()))){
                messageMap.getMapa().put(loginValidation.getUsername(),new HashMap<String, ArrayList<Message>>()); // ii cream userului
                                                                                                // logat o mapa de mesaje
               /* messageMap.getMapa().put(principal.getName(),new HashMap<String, ArrayList<Message>>());*/
                model.addAttribute("userAccount",user);
                return "log/logged";
                }
            else {
                return "log/unlogged";
            }

        }
        catch(HibernateException hibernateException){
            hibernateException.printStackTrace();
            return "log/unlogged";
        }
    }

  /*  @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String checkAcount(){
        return "log/logged";
    }*/

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String singUp(){
        return "log/login";
    }

    @RequestMapping(value = "/registrationon", method = RequestMethod.GET)
    public String registrationUp(ModelMap map){
        User user = new User();
        map.put("user",user);
        return "registration/registration";
    }

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String welcomePage(ModelMap model,Principal principal){
        System.out.println("asdasdasdas");
        model.addAttribute("username",principal.getName());
        model.addAttribute("message","This is welcome pageeee");
        return "welcomePage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model){
        return "/logare";
    }

    @RequestMapping(value="/logoutSuccessful", method = RequestMethod.GET)
    public String logoutPage(){
        return "/home";
    }
}
