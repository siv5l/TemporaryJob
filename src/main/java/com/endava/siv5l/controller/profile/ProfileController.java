package com.endava.siv5l.controller.profile;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by siv5l on 5/9/16.
 */
@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profiles/{useraccount}/", method = RequestMethod.GET)
    public String watchAccount(@PathVariable("useraccount") String useraccount,ModelMap model,HttpSession httpSession){
        User user = userService.getByUsername(useraccount);
        User currentUser = (User) httpSession.getAttribute("userAccount");
        model.addAttribute("requiredUser",user);
        System.out.println(user.getFirstName());

        if(currentUser == null){
            return "profile/cloneuserProfileAccount";
        }
        else {
            return "profile/userProfileAccount";
        }
    }
}
