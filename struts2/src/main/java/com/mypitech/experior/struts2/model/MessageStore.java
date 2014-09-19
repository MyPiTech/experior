/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package com.mypitech.experior.struts2.model;

/**
 * Created by Shawn Wheeler on 8/31/2014.
 */
public class MessageStore {
    private String message;

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = "Hello world, " + message + "!";
    }
}
