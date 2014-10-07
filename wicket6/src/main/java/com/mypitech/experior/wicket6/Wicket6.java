package com.mypitech.experior.wicket6;

import com.mypitech.experior.wicket6.ui.page.Home;
import org.apache.wicket.Page;
import org.apache.wicket.core.util.file.WebApplicationPath;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Created by Shawn Wheeler on 9/26/2014.
 */
public class Wicket6 extends WebApplication {

    @Override
    public void init() {
        super.init();
        getResourceSettings().getResourceFinders().add(new WebApplicationPath(getServletContext(), "/"));
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return Home.class;
    }
}
