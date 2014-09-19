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
import java.util.List;

/**
 * Created by Shawn Wheeler on 9/2/2014.
 */
@Namespace("/")
@Action("listUsers")
@Result(name = "success", location = "/listUsers.jsp")
public class ListUserAction extends ActionSupport {

    @Inject
    private UserService userService;

    private List<UserBean> users;

    public String execute() throws Exception {
        this.users = userService.all();
        return SUCCESS;
    }

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }
}
