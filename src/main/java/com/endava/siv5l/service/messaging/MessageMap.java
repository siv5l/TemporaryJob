package com.endava.siv5l.service.messaging;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by siv5l on 4/12/16.
 */
@Component
public class MessageMap {

    HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();


    public MessageMap(){}

    public MessageMap(HashMap<String, ArrayList<String>> map) {
        this.map = map;
    }

    public HashMap<String, ArrayList<String>> getMap() {
        return map;
    }

    public void setMap(HashMap<String, ArrayList<String>> map) {
        this.map = map;
    }
}
