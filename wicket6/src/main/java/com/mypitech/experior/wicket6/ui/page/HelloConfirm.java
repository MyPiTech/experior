package com.mypitech.experior.wicket6.ui.page;

import com.mypitech.experior.wicket6.ui.panel.HelloConfirmPanel;
import com.mypitech.experior.wicket6.ui.panel.layout.Template;
import com.mypitech.experior.wicket6.ui.panel.layout.TopNav;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class HelloConfirm extends Template {

    public HelloConfirm(String name) {
        super();
        replace(new HelloConfirmPanel(CONTENT_ID, name));
        TopNav topNav = (TopNav) getTopNav();
        topNav.setHelloItemActive();
    }
}
