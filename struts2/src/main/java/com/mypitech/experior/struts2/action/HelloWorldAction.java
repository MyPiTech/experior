/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package com.mypitech.experior.struts2.action;

import com.mypitech.experior.struts2.model.MessageStore;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by Shawn Wheeler on 8/31/2014.
 */
@Namespace("/")
@Action("helloSubmitted")
@Result(name = "success", location = "/helloWorldConfirm.jsp")
public class HelloWorldAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private MessageStore messageStore;

    public String result() throws Exception {
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

}

