package com.endava.siv5l.controller.chat;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.messaging.Message;
import com.endava.siv5l.service.messaging.MessageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by siv5l on 4/15/16.
 */
@Controller
public class MessagesController {

    @Autowired
    private MessageMap messageMap;


    @RequestMapping("/messages/{username}")
    public String returnMessages(@PathVariable("username") String username,ModelMap model,HttpSession httpSession){

        User user  = (User) httpSession.getAttribute("userAccount");
        String currentUser = user.getUsername();
        HashMap<String,ArrayList<Message>> userMessages  = messageMap.getMapa().get(currentUser);
        ArrayList<Message>  msgs  = userMessages.get(username);

        model.addAttribute("messagesArray",msgs);
        model.addAttribute("messageUsers",userMessages);
        return "messages";
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String redirectToMessages(ModelMap model,HttpSession httpSession){
        try{
            User user = (User) httpSession.getAttribute("userAccount");
            String username = user.getUsername();
            HashMap<String, ArrayList<Message>> userMessages = messageMap.getMapa().get(username);
            model.addAttribute("messageUsers", userMessages);
        }catch (NullPointerException ex){
            return "messages";
        }
        return "messages";
    }
}
