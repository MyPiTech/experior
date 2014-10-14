package com.mypitech.experior.spring4.repository.bean;

import java.io.Serializable;

/**
 * Created by Shawn Wheeler on 9/13/2014.
 */
public class UserBean implements Serializable{
    private String identity;
    private String name;
    private String description;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
