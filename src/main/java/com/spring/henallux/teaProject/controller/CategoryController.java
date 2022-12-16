package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.teaProject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.teaProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/tea-category")
public class CategoryController {

    private CategoryDataAccess categoryDAO;

    @Autowired
    public void getCategories(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("categoryList", categoryDAO.getCategories());
        return "integrated:category";
    }
}
