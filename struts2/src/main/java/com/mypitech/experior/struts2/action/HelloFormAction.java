/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package com.mypitech.experior.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by Shawn Wheeler on 9/2/2014.
 */
@Namespace("/")
@Action("hello")
@Result(name = "success", location = "/helloWorldForm.jsp")
public class HelloFormAction extends ActionSupport {
    //@Action(value = "hello", results = {@Result(name = "success", location = "/helloWorldForm.jsp")})
    public String helloAction() {
        return SUCCESS;
    }

}
