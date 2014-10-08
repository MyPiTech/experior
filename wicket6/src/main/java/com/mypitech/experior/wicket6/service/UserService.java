package com.mypitech.experior.wicket6.service;

import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.wicket6.service.util.HttpUtil;
import org.apache.http.client.utils.URIBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shawn Wheeler on 10/7/2014.
 */
public class UserService implements Serializable{
    private final static String APPLICATION_DOMAIN = System.getProperty("APPLICATION_DOMAIN");

    public List<UserBean> getAll(){
        List<UserBean> returnList = null;
        try {
            returnList = HttpUtil.getList(new URIBuilder(APPLICATION_DOMAIN).setPath("/rest-api/user/all").build(), UserBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnList;
    }

    public UserBean read(String identity){
        UserBean user = null;
        try {
            user = HttpUtil.get(new URIBuilder(APPLICATION_DOMAIN).setPath("/rest-api/user/read").addParameter("identity", identity).build(), UserBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void create(UserBean user){
        try {
            HashMap<String, String> resultMap = HttpUtil.post(new URIBuilder(APPLICATION_DOMAIN).setPath("/rest-api/user/create").build(), user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String identity, UserBean user){
        try {
            HttpUtil.put(new URIBuilder(APPLICATION_DOMAIN).setPath("/rest-api/user/update").addParameter("identity", identity).build(), user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String identity){
        try {
            HttpUtil.delete(new URIBuilder(APPLICATION_DOMAIN).setPath("/rest-api/user/delete").addParameter("identity", identity).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
