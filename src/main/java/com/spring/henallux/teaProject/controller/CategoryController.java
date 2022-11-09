package com.spring.henallux.teaProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/tea-category")
public class CategoryController {
    @RequestMapping (method = RequestMethod.GET)
    public String category(Model model) {
        return "integrated:category";
    }
}
