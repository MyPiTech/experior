package com.mypitech.experior.wicket6.domain.dao;


import com.mypitech.experior.wicket6.domain.bean.UserBean;

import java.util.List;

/**
 * Created by Shawn Wheeler on 9/18/2014.
 */
public interface IUserDao {
    final static String GET_ALL = "UserEntity.all";

    UserBean read(String identity);
    String create(UserBean user);
    void update(String identity, UserBean user);
    void delete(String identity);
    List<UserBean> all();
}
