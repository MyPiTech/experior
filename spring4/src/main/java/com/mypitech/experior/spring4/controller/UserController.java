package com.mypitech.experior.spring4.controller;

import com.mypitech.experior.spring4.repository.bean.UserBean;
import com.mypitech.experior.spring4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Shawn Wheeler on 10/9/2014.
 */
@Controller
public class UserController {

    @Inject
    private UserService userService;

    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public String listUsers(Model model) {
        List<UserBean> users = userService.all();
        model.addAttribute("users", users);
        return "listUsers";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(Model model, @RequestParam String identity) {
        userService.delete(identity);
        List<UserBean> users = userService.all();
        model.addAttribute("users", users);
        return "listUsers";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
     public String createUser(Model model) {
        UserBean userForm = new UserBean();
        model.addAttribute("headerText", "Create User");
        model.addAttribute("buttonText", "Create");
        model.addAttribute("userForm", userForm);
        return "updateUser";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createNewUser(Model model, UserBean userForm) {
        userService.create(userForm);
        List<UserBean> users = userService.all();
        model.addAttribute("users", users);
        return "listUsers";
    }


    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(Model model, @RequestParam String identity) {
        UserBean userForm = userService.read(identity);
        model.addAttribute("headerText", "Update User");
        model.addAttribute("buttonText", "Update");
        model.addAttribute("userForm", userForm);
        return "updateUser";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String saveUser(Model model, UserBean userForm) {
        userService.update(userForm.getIdentity(), userForm);
        List<UserBean> users = userService.all();
        model.addAttribute("users", users);
        return "listUsers";
    }

}
