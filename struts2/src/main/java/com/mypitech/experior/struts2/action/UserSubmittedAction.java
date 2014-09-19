/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package com.mypitech.experior.struts2.action;


import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.struts2.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;

/**
 * Created by Shawn Wheeler on 9/3/2014.
 */
@Namespace("/")
@Action("userSubmitted")
@Result(name = "success", type = "redirectAction", params = {"actionName", "listUsers"})
public class UserSubmittedAction extends ActionSupport {
    @Inject
    private UserService userService;

    private UserBean user;

    public String execute() throws Exception {

        try {
            if (user.getIdentity().isEmpty()) {
                createUser();
            } else {
                updateUser();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public void createUser() throws Exception {
        userService.create(user);
    }

    public void updateUser() throws Exception {
        userService.update(user.getIdentity(), user);
    }

}
