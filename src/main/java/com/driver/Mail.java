package com.driver;

import java.util.Date;

public class Mail {
    private Date date;

    private String sender;

    private String message;

    public Mail(Date date, String sender, String message) {
        this.sender = sender;
        this.date = date;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }
}