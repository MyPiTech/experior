package com.mypitech.experior.wicket6.ui.panel.layout;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class Template extends WebPage {
    public static final String CONTENT_ID = "content";
    public String currentPage = "test";
    private Component header;
    private Component menu;
    private Component footer;
    private Component topNav;

    public Template() {
        super();
        addComponents();
    }

    public Template(final PageParameters parameters) {
        super(parameters);
        addComponents();
    }


    private void addComponents() {
        add(header = new Header("header"));
        add(menu = new Menu("menu"));
        add(footer = new Footer("footer"));
        add(topNav = new TopNav("topNav"));
        add(new Label(CONTENT_ID, "Put your content here"));

    }

    public Component getHeader() {
        return header;
    }

    public void setHeader(Component header) {
        this.header = header;
    }

    public Component getMenu() {
        return menu;
    }

    public void setMenu(Component menu) {
        this.menu = menu;
    }

    public Component getFooter() {
        return footer;
    }

    public void setFooter(Component footer) {
        this.footer = footer;
    }

    public Component getTopNav() {
        return topNav;
    }

    public void setTopNav(Component topNav) {
        this.topNav = topNav;
    }
}
