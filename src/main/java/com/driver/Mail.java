package com.driver;

import java.util.Date;

public class Mail {
    Date date;

    String sender;

    String message;

    public Mail(Date date, String sender, String message) {
        this.sender = sender;
        this.date = date;
        this.message = message;
    }
}
