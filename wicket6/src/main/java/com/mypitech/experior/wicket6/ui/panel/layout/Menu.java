package com.mypitech.experior.wicket6.ui.panel.layout;

import com.mypitech.experior.wicket6.ui.page.Crud;
import com.mypitech.experior.wicket6.ui.page.Hello;
import com.mypitech.experior.wicket6.ui.page.Home;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class Menu extends Panel {

    /**
     * @param id
     * @see org.apache.wicket.Component#Component(String)
     */
    public Menu(String id) {
        super(id);
        addComponents();
    }

    private void addComponents() {

        add(new Link<Void>("homeLink") {
            @Override
            public void onClick() {
                setResponsePage(new Home());
            }
        });
        add(new Link<Void>("helloLink") {
            @Override
            public void onClick() {
                setResponsePage(new Hello());
            }
        });
        add(new Link<Void>("crudLink") {
            @Override
            public void onClick() {
                setResponsePage(new Crud());
            }
        });
    }
}
