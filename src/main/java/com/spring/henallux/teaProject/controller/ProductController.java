package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.teaProject.dataAccess.dao.ProductDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/tea-product")
public class ProductController {
    private ProductDataAccess productDAO;

    @Autowired
    public void getProducts(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model, @RequestParam(required = true, defaultValue = "black") String category) {
        model.addAttribute("productsList", productDAO.getProductsByCategory(category));
        return "integrated:product";
    }

}
