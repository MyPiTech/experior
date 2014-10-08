package com.mypitech.experior.wicket6.ui.panel;

import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.wicket6.model.UserModel;
import com.mypitech.experior.wicket6.service.UserService;
import com.mypitech.experior.wicket6.ui.page.Crud;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class UserEditPanel extends Panel {
    private IModel<UserBean> model;
    /**
     * @param id
     * @see org.apache.wicket.Component#Component(String)
     */
    public UserEditPanel(String id, IModel<UserBean> model) {
        super(id);
        this.model = model;
        setDefaultModel(model);
        addComponents();
    }

    private void addComponents() {
        String headerString;
        boolean isNew = model.getObject().getIdentity().isEmpty();
        if(isNew){
            headerString = "Create User";
        } else {
            headerString = "Update User";
        }

        add(new Label("editFormHeader", headerString));

        add(new Link<Void>("returnLink") {
            @Override
            public void onClick() {
                setResponsePage(new Crud());
            }
        });
        add(new UserForm("userEditForm", isNew));
    }

    private class UserForm extends Form<UserModel> {
        private UserService userService = new UserService();
        private boolean isNew = true;

        /**
         * Constructs a form with no validation.
         *
         * @param id See Component
         */
        public UserForm(String id, boolean isNew) {
            super(id, new CompoundPropertyModel<UserModel>(new UserModel(model.getObject())));
            this.isNew = isNew;
            add(new TextField<String>("name"));
            add(new TextArea<String>("description"));
            add(new Button("createSubmit").setVisible(isNew));
            add(new Button("updateSubmit").setVisible(!isNew));
        }

        @Override
        public void onSubmit() {
            UserBean user = (UserBean) getDefaultModelObject();
            if(isNew){
                userService.create(user);
            }else{
                userService.update(user.getIdentity(), user);
            }
            setResponsePage(new Crud());
        }

    }

}
