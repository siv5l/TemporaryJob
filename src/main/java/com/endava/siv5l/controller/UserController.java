package com.endava.siv5l.controller;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by siv5l on 4/7/16.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("/index")
    public String setupForm(Map<String,Object> map){
        User user = new User();
        map.put("user",user);
        map.put("userList", userService.getAllUsers());
        return "User";
    }

    @RequestMapping(value="/user.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String,Object> map){
        User userResult = new User();

        String s = action.toLowerCase();
        if (s.equals("add")) {
            userService.add(user);
            userResult = user;

        } else if (s.equals("edit")) {
            userService.edit(user);
            userResult = user;

        } else if (s.equals("delete")) {
            userService.delete(user.getUserId());
            userResult = new User();

        } else if (s.equals("search")) {
            User searchUser = userService.getUser(user.getUserId());
            userResult = searchUser != null ? searchUser : new User();

        }

        String username = user.getUsername();
        User userDoi = (User) userService.getByUsername(username);
        System.out.println((userDoi.getPassword()));

        map.put("user", userResult);
        map.put("userList",userService.getAllUsers());
        return "User";
    }
}
