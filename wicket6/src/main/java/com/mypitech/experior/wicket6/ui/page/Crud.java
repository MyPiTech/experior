package com.mypitech.experior.wicket6.ui.page;


import com.mypitech.experior.wicket6.ui.panel.CrudPanel;
import com.mypitech.experior.wicket6.ui.panel.layout.Template;
import com.mypitech.experior.wicket6.ui.panel.layout.TopNav;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class Crud extends Template {
    public Crud() {
        super();
        replace(new CrudPanel(CONTENT_ID));
        TopNav topNav = (TopNav) getTopNav();
        topNav.setCrudItemActive();
    }
}
