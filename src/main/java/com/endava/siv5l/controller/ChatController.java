package com.endava.siv5l.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

import java.util.Queue;

/**
 * Created by siv5l on 4/10/16.
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
   /*
    @Autowired
    private Map<String, Queue<String>> messageMap;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String get(HttpSession httpSession) {
        Queue<String> messages = messageMap.get(httpSession.getId());

        StringBuilder sb = new StringBuilder();
        while(!messages.isEmpty()) {
            sb.append(messages + "\n");
        }

        return sb.toString();  */

    }

  // Request* Mapping("/put/{target}")