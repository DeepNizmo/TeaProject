package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
@RequestMapping(value= "/login")

public class LoginController {
    private MessageSource messageSource;

    @Autowired
    public LoginController(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @RequestMapping(method= RequestMethod.GET)
    public String get (Model model, Locale locale, @RequestParam(required = false)String error) {
        model.addAttribute("userModel", new User());
        if(error != null) model.addAttribute("errorLogin", messageSource.getMessage("errorLogin", new Object[0], locale));
        return "integrated:login";
    }

}