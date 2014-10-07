package com.mypitech.experior.wicket6.ui.page;

import com.mypitech.experior.wicket6.ui.panel.HelloPanel;
import com.mypitech.experior.wicket6.ui.panel.layout.Template;
import com.mypitech.experior.wicket6.ui.panel.layout.TopNav;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class Hello extends Template {

    public Hello() {
        super();
        replace(new HelloPanel(CONTENT_ID));
        TopNav topNav = (TopNav) getTopNav();
        topNav.setHelloItemActive();
    }
}
