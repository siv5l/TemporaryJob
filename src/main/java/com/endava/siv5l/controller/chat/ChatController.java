package com.endava.siv5l.controller.chat;

import com.endava.siv5l.model.User;
import com.endava.siv5l.service.messaging.Message;
import com.endava.siv5l.service.messaging.MessageMap;
import com.endava.siv5l.service.messaging.PostMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by siv5l on 4/12/16.
 */
@Controller
public class ChatController {

    @Autowired
    private MessageMap messageMap;


    @RequestMapping(value="/insertmessage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ArrayList<Message> insertMessages(@RequestBody PostMessage postMessage, HttpSession session){
        String toWhom = postMessage.getToWhom();
        String sendMessage = postMessage.getMsgToSend();
        ArrayList<Message> msgs = null;

        try {
            User user = (User) session.getAttribute("userAccount");
            Message message = new Message();
            message.setTo(toWhom);
            message.setFrom(user.getLastName());
            message.setContentMsg(sendMessage);
            Date date = new Date();
            message.setDate(date);

            if((messageMap.getMapa().get(toWhom).get(user.getUsername())) == null) {
                messageMap.getMapa().get(toWhom).put(user.getUsername(), new ArrayList<Message>()); //
                messageMap.getMapa().get(user.getUsername()).put(toWhom, new ArrayList<Message>()); // lui personl
            }
            if(!toWhom.equals(user.getUsername())) {
                messageMap.getMapa().get(toWhom).get(user.getUsername()).add(message);
                messageMap.getMapa().get(user.getUsername()).get(toWhom).add(message); // lui personal
            }else{
                messageMap.getMapa().get(user.getUsername()).get(toWhom).add(message);
            }
            String username = user.getUsername();
            HashMap<String, ArrayList<Message>> userMessages = messageMap.getMapa().get(username);
            msgs  = userMessages.get(toWhom); //toate mesajele cu acela care vorbesc, din hashMapu meu

        } catch (NullPointerException e){
            User user = (User) session.getAttribute("userAccount");
            String username = user.getUsername();
            HashMap<String, ArrayList<Message>> userMessages = messageMap.getMapa().get(username);
            msgs  = userMessages.get(toWhom); //toate mesajele cu acela care vorbesc, din hashMapu meu
            e.getMessage();
            return msgs;
        }
       return msgs;
    }

    @RequestMapping(value="/retrievemessage", method = RequestMethod.GET)
    public @ResponseBody
    HashMap<String, ArrayList<Message>> retrieveMessages(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("userAccount");
        String username = user.getUsername();
        HashMap<String, ArrayList<Message>> userMessages = messageMap.getMapa().get(username);
        return userMessages;
    }

}
