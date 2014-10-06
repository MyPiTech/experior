/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package com.mypitech.experior.wicket6.service;

import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.domain.dao.impl.UserDao;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Shawn Wheeler on 9/2/2014.
 */
@Stateless
public class UserService {

    private final static Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Inject
    private UserDao userDao;

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

    public List<UserBean> all(){
        return userDao.all();
    }

}
