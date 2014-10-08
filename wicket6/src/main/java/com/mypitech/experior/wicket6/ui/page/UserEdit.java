package com.mypitech.experior.wicket6.ui.page;


import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.wicket6.model.UserModel;
import com.mypitech.experior.wicket6.ui.panel.UserEditPanel;
import com.mypitech.experior.wicket6.ui.panel.layout.Template;
import com.mypitech.experior.wicket6.ui.panel.layout.TopNav;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by Shawn Wheeler on 10/1/2014.
 */
public class UserEdit extends Template {
    private String userId;

    public UserEdit(final PageParameters parameters) {
        super(parameters);
        this.userId = parameters.get("userId").toString();
        IModel<UserBean> userModel;
        if(userId == null || userId.isEmpty()){
            UserBean newUser = new UserBean();
            newUser.setIdentity("");
            newUser.setName("");
            newUser.setDescription("");
            userModel = new UserModel(newUser);
        }else{
            userModel = new UserModel(userId);
        }
        replace(new UserEditPanel(CONTENT_ID, userModel));
        TopNav topNav = (TopNav) getTopNav();
        topNav.setCrudItemActive();
    }
}
