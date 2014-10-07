package com.mypitech.experior.wicket6.ui.panel;

import com.mypitech.experior.wicket6.ui.page.Hello;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class HelloConfirmPanel extends Panel {
    /**
     * @param id
     * @see org.apache.wicket.Component#Component(String)
     */
    public HelloConfirmPanel(String id, String name) {
        super(id);
        String nameString = "Hello world, " + name + "!";
        Model<String> nameModel = Model.of(nameString);
        add(new Label("name", nameModel));
        add(new Link<Void>("helloLink") {
            @Override
            public void onClick() {
                setResponsePage(new Hello());
            }
        });
    }


}
