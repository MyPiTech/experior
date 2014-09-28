package com.mypitech.experior.wicket6;

import org.apache.wicket.Page;
import org.apache.wicket.core.util.file.WebApplicationPath;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Created by Shawn Wheeler on 9/26/2014.
 */
public class Wicket6 extends WebApplication {
    /**
     * Application subclasses must specify a home page class by implementing this abstract method.
     *
     * @return Home page class for this application
     */
    @Override
    public Class<? extends Page> getHomePage() {
        return null;
    }

    @Override
    public void init() {
        super.init();
        getResourceSettings().getResourceFinders().add(new WebApplicationPath(getServletContext(), "/"));
    }
}
