package com.mypitech.experior.wicket6.ui.module;

import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.wicket6.service.UserService;
import org.apache.wicket.model.LoadableDetachableModel;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Shawn Wheeler on 10/6/2014.
 */
@Stateless
public class UserModel  extends LoadableDetachableModel<UserBean> {
    @Inject
    private UserService userService;
    /**
     * Loads and returns the (temporary) model object.
     *
     * @return the (temporary) model object
     */
    @Override
    protected UserBean load() {
        return userService.read("b0b8daf0-44ed-11e4-94aa-f1a255884f61");
    }
}
