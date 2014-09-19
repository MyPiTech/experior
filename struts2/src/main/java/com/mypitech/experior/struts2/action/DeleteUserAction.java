/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package com.mypitech.experior.struts2.action;

import com.mypitech.experior.struts2.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;

/**
 * Created by Shawn Wheeler on 9/4/2014.
 */
@Namespace("/")
@Action("deleteUser")
@Result(name = "success", type = "redirectAction", params = {"actionName", "listUsers"})
public class DeleteUserAction extends ActionSupport {

    @Inject
    private UserService userService;
    private String identity;

    public String execute() throws Exception {
        userService.delete(identity);
        return SUCCESS;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
