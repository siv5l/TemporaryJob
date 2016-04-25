package com.endava.siv5l.service.messaging;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by siv5l on 4/12/16.
 */
@Component
public class MessageMap {

    HashMap<String,HashMap<String,ArrayList<Message>>> mapa = new HashMap<String, HashMap<String, ArrayList<Message>>>();


    public MessageMap(){}

    public MessageMap(HashMap<String, HashMap<String, ArrayList<Message>>> mapa) {
        this.mapa = mapa;
    }

    public HashMap<String, HashMap<String, ArrayList<Message>>> getMapa() {
        return mapa;
    }

    public void setMapa(HashMap<String, HashMap<String, ArrayList<Message>>> mapa) {
        this.mapa = mapa;
    }
}
