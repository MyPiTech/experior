package com.mypitech.experior.jersey2.service;


import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.domain.dao.IUserDao;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Shawn Wheeler on 9/13/2014.
 */
@Stateless
public class UserService {

    @Inject
    private IUserDao userDao;

    public void create(UserBean user){
        userDao.create(user);
    }

    public void update(String identity, UserBean user){
        userDao.update(identity, user);
    }

    public UserBean read(String identity){
        return userDao.read(identity);
    }

    public void delete(String identity){
        userDao.delete(identity);
    }
}
