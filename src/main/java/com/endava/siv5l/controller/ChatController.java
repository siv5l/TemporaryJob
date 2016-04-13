package com.endava.siv5l.controller;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.messaging.MessageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by siv5l on 4/12/16.
 */
@Controller
public class ChatController {

    @Autowired
    MessageMap messageMap;


    @RequestMapping(value="/insertmessage", method = RequestMethod.POST)
    public String insertMessages(@RequestParam("toWhom") String toWhom,@RequestParam("sendMessage") String sendMessage){
        try {
            messageMap.getMap().get(toWhom).add(sendMessage);
            for(Map.Entry<String,ArrayList<String>> entry : messageMap.getMap().entrySet()){
                System.out.println("username: " + entry.getKey());
                ArrayList<String> array = entry.getValue();
                for(String str : array){
                    System.out.println("mesajul: " +  str);
                }
            }
        }catch (NullPointerException e){
            e.getMessage();
            System.out.println("1");
            return "logged";
        }
        return "logged";
    }

    @RequestMapping(value="/retrievemessage", method = RequestMethod.GET)
    public String retrieveMessages(ModelMap modelamap,HttpSession httpSession) {
        User user  = (User) httpSession.getAttribute("userAccount");
        String username = user.getUsername();
        ArrayList<String> userMessages = messageMap.getMap().get(username);
        modelamap.addAttribute("messages",userMessages);
        return "messages";
    }
}
