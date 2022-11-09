package com.spring.henallux.teaProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/home")
public class WelcomeController {
    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model) {
        return "integrated:welcome";
    }
}
