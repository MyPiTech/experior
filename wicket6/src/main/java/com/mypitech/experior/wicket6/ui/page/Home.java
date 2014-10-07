package com.mypitech.experior.wicket6.ui.page;

import com.mypitech.experior.wicket6.ui.panel.HomePanel;
import com.mypitech.experior.wicket6.ui.panel.layout.Template;
import com.mypitech.experior.wicket6.ui.panel.layout.TopNav;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class Home extends Template {

    public Home() {
        super();
        replace(new HomePanel(CONTENT_ID));
        TopNav topNav = (TopNav) getTopNav();
        topNav.setHomeItemActive();
    }
}
