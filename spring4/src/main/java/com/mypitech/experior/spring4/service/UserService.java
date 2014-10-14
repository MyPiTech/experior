/*
 * Copyright (c) 2014. Shawn Wheeler. All rights reserved.
 */

package com.mypitech.experior.spring4.service;


import com.mypitech.experior.spring4.repository.bean.UserBean;
import com.mypitech.experior.spring4.repository.dao.impl.UserDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Shawn Wheeler on 9/2/2014.
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class UserService {

    private final static Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Inject
    private UserDao userDao;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void create(UserBean user){
        userDao.create(user);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void update(String identity, UserBean user){
        userDao.update(identity, user);
    }

    public UserBean read(String identity){
        return userDao.read(identity);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void delete(String identity){
        userDao.delete(identity);
    }

    public List<UserBean> all(){
        return userDao.all();
    }
}
