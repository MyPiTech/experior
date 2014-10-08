package com.mypitech.experior.wicket6.ui.panel;

import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.wicket6.service.UserService;
import com.mypitech.experior.wicket6.ui.page.Crud;
import com.mypitech.experior.wicket6.ui.page.UserEdit;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class CrudPanel extends Panel {

    private UserService userService = new UserService();
    /**
     * @param id
     * @see org.apache.wicket.Component#Component(String)
     */
    public CrudPanel(String id) {
        super(id);
        addComponents();
    }

    public void addComponents(){
        List<UserBean> users = userService.getAll();
        ListDataProvider<UserBean> listDataProvider = new ListDataProvider<UserBean>(users);
        DataView<UserBean> dataView = new DataView<UserBean>("rows", listDataProvider) {
            @Override
            protected void populateItem(Item<UserBean> item) {
                final UserBean user  = item.getModelObject();
                RepeatingView textRepeatingView = new RepeatingView("textData");
                textRepeatingView.add(new Label(textRepeatingView.newChildId(), user.getName()));
                textRepeatingView.add(new Label(textRepeatingView.newChildId(), user.getDescription()));

                item.add(textRepeatingView);
                item.add(new Link<Void>("updateLink") {
                    @Override
                    public void onClick() {
                        PageParameters pageParameters = new PageParameters();
                        pageParameters.add("userId", user.getIdentity());
                        setResponsePage(new UserEdit(pageParameters));
                    }
                });
                item.add(new Link<Void>("deleteLink") {
                    @Override
                    public void onClick() {
                        userService.delete(user.getIdentity());
                        setResponsePage(new Crud());
                    }
                });
            }
        };
        add(new Link<Void>("newUserLink") {
            @Override
            public void onClick() {
                PageParameters pageParameters = new PageParameters();
                pageParameters.add("userId", "");
                setResponsePage(new UserEdit(pageParameters));
            }
        });
        add(dataView);
    }

}
