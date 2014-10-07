package com.mypitech.experior.wicket6.ui.panel;

import com.mypitech.experior.wicket6.ui.page.HelloConfirm;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class HelloPanel extends Panel {
    /**
     * @param id
     * @see org.apache.wicket.Component#Component(String)
     */
    public HelloPanel(String id) {
        super(id);
        add(new HelloForm("helloForm"));
    }

    public class HelloForm extends StatelessForm {
        private String name;

        /**
         * Constructs a form with no validation.
         *
         * @param id See Component
         */
        public HelloForm(String id) {
            super(id);
            setDefaultModel(new CompoundPropertyModel(this));
            add(new TextField<String>("name"));
            add(new Button("submitButton"));
        }

        @Override
        public void onSubmit() {
            setResponsePage(new HelloConfirm(name));

        }
    }

}
