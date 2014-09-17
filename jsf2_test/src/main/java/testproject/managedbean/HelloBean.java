/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package testproject.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Shawn Wheeler on 8/30/2014.
 */
@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
