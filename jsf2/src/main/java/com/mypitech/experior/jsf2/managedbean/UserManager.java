package com.mypitech.experior.jsf2.managedbean;

import com.mypitech.experior.domain.bean.UserBean;
import com.mypitech.experior.jsf2.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Shawn Wheeler on 9/24/2014.
 */
@ManagedBean
@SessionScoped
public class UserManager implements Serializable {

    @Inject
    private UserService userService;
    private List<UserBean> users;
    private UserBean currentUser;
    private String identity;
    private String name;
    private String description;
    private boolean isNew = true;
    private String headerText;
    private String buttonText;

    public List<UserBean> getUsers() {
        return userService.all();
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public UserBean getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserBean currentUser) {
        this.currentUser = currentUser;
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

    public String createUser(){
        if(isNew){
            UserBean newUser = new UserBean();
            newUser.setName(getName());
            newUser.setDescription(getDescription());
            userService.create(newUser);
        }else{
            currentUser.setName(getName());
            currentUser.setDescription(getDescription());
            userService.update(currentUser.getIdentity(), currentUser);
        }

        return "userList";
    }

    public String deleteUser(String identity){
        userService.delete(identity);
        return "userList";
    }

    public String newUser(){
        isNew = true;
        setName("");
        setDescription("");
        setIdentity("");
        setHeaderText("Create User");
        setButtonText("Create");
        return "userForm";
    }

    public String updateUser(String identity){
        setHeaderText("Update User");
        setButtonText("Update");
        setCurrentUser(userService.read(identity));
        setName(currentUser.getName());
        setDescription(currentUser.getDescription());
        isNew = false;
        return "userForm";
    }
}
