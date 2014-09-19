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
 * Created by Shawn Wheeler on 9/2/2014.
 */
@Namespace("/")
@Action("updateUser")
@Result(name = "success", location = "/updateUser.jsp")
public class UpdateUserAction extends ActionSupport {
    @Inject
    private UserService userService;
    private String identity;
    private UserBean user;

    public String execute() throws Exception {
        if (identity == null) {
            this.user = new UserBean();
        } else {
            this.user = userService.read(identity);
        }
        return SUCCESS;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
}
