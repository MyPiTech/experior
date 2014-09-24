package com.mypitech.experior.jersey2.service;


import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.domain.dao.IUserDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Shawn Wheeler on 9/13/2014.
 */
@Stateless
public class UserService {

    @Inject
    private IUserDao userDao;

    public String create(UserBean user){
        return userDao.create(user);
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
