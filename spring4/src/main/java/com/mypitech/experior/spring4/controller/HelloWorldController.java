package com.mypitech.experior.spring4.controller;

import com.mypitech.experior.spring4.model.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Shawn Wheeler on 10/9/2014.
 */
@Controller
@RequestMapping(value = "/helloWorldForm")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorldForm(Model model) {
        Hello helloForm = new Hello();
        model.addAttribute("helloForm", helloForm);
        return "helloWorldForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String helloWorldFormConfirm(Model model, Hello helloForm) {
        model.addAttribute("name", helloForm.getName());
        return "helloWorldConfirm";
    }

}
