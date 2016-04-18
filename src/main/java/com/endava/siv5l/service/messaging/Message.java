package com.endava.siv5l.service.messaging;

import java.util.Date;

/**
 * Created by siv5l on 4/15/16.
 */
public class Message {

    private String to;
    private String from;
    private String contentMsg;
    private Date date;


    public Message(){}


    public Message(String to, String from, String contentMsg, Date date) {
        this.to = to;
        this.from = from;
        this.contentMsg = contentMsg;

        this.date = date;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContentMsg() {
        return contentMsg;
    }

    public void setContentMsg(String contentMsg) {
        this.contentMsg = contentMsg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
