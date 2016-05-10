package com.endava.siv5l.controller.userdetails;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by siv5l on 5/10/16.
 */
@Controller
public class UserDetailsController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/profiles/{username}", method = RequestMethod.GET)
    public String showUserDetails(@PathVariable("username") String username, ModelMap modelMap, HttpSession httpSession){
        User user = userService.getByUsername(username);
        User currentUser = (User) httpSession.getAttribute("userAccount");
        modelMap.addAttribute("userDetails",user);
        if(currentUser == null){
            return "profile/cloneuserDetails";
        }
        else{
            return "profile/userDetails";
        }
    }
}
