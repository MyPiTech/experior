package com.mypitech.experior.wicket6.model;

import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.wicket6.service.UserService;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 * Created by Shawn Wheeler on 10/7/2014.
 */
public class UserModel extends LoadableDetachableModel<UserBean> {

    private UserService userService = new UserService();
    private String identity;
    private String name;
    private String description;

    /**
     * This constructor is used if you already have the object retrieved and want to wrap it with a
     * detachable model.
     *
     * @param userBean retrieved instance of the detachable object
     */
    public UserModel(UserBean userBean) {
        super(userBean);
        this.identity = userBean.getIdentity();
        this.name = userBean.getName();
        this.description = userBean.getDescription();
    }

    /**
     * Construct.
     */
    public UserModel(String identity) {
        this.identity = identity;
    }

    /**
     * Loads and returns the (temporary) model object.
     *
     * @return the (temporary) model object
     */
    @Override
    protected UserBean load() {
        UserBean user = null;
        if (identity == null || identity.isEmpty()){
            user = new UserBean();
        }else{
            user = userService.read(identity);
        }
        return user;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
