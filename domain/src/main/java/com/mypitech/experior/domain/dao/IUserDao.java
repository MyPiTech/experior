package com.mypitech.experior.domain.dao;

import com.mypitech.experior.domain.bean.UserBean;

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
