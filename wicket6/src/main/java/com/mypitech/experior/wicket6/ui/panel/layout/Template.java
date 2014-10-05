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

    /**
     * Constructor which receives wrapped query string parameters for a request. Having this
     * constructor public means that your page is 'bookmarkable' and hence can be called/ created
     * from anywhere. For bookmarkable pages (as opposed to when you construct page instances
     * yourself, this constructor will be used in preference to a no-arg constructor, if both exist.
     * Note that nothing is done with the page parameters argument. This constructor is provided so
     * that tools such as IDEs will include it their list of suggested constructors for derived
     * classes.
     * <p/>
     * Please call this constructor if you want to remember the pageparameters
     * {@link #getPageParameters()}. So that they are reused for stateless links.
     *
     * @param parameters Wrapped query string parameters.
     */
    public Template(PageParameters parameters) {
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
