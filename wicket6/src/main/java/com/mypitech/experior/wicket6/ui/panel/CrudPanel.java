package com.mypitech.experior.wicket6.ui.panel;

import com.mypitech.experior.wicket6.ui.module.UserModel;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class CrudPanel extends Panel {


    /**
     * @param id
     * @see org.apache.wicket.Component#Component(String)
     */
    public CrudPanel(String id) {
        super(id);
        UserModel testModel = new UserModel();
        addComponents();
    }

    public void addComponents(){

    }

}