package com.endava.siv5l.service.messaging;

import java.io.Serializable;

/**
 * Created by siv5l on 4/19/16.
 */
public class PostMessage  implements Serializable{

    private String toWhom;
    private String msgToSend;

    public PostMessage(){}

    public PostMessage(String toWhom, String msgToSend) {
        this.toWhom = toWhom;
        this.msgToSend = msgToSend;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public String getMsgToSend() {
        return msgToSend;
    }

    public void setMsgToSend(String msgToSend) {
        this.msgToSend = msgToSend;
    }
}
