package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.teaProject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.teaProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.teaProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.model.CartItem;
import com.spring.henallux.teaProject.model.Product;
import com.spring.henallux.teaProject.service.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping(value="/tea-product")
@SessionAttributes({Constants.CURRENT_CART})
public class ProductController {
    private ProductDataAccess productDAO;
    private CategoryDataAccess categoryDAO;

    @Autowired
    public void getProducts(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void getCategories(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() {return new Cart();}

    @RequestMapping (value = "/{categoryId}", method = RequestMethod.GET)
    public String home(Model model, @PathVariable("categoryId")String categoryId, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart, Locale locale) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        for (Product product: productDAO.getProductsByCategory(categoryId)) {
            System.out.println(product.getActualPrice());
        }
        model.addAttribute("productsList", productDAO.getProductsByCategory(categoryId));
        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("translatedCategory", categoryDAO.getCategoryById(locale.getLanguage(), categoryId).getTranslation());
        return "integrated:product";
    }

    @RequestMapping (value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(Model model, @ModelAttribute(value = "cartItem") CartItem item, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        cart.addProduct(item.getId(), item);
        String categoryId = item.getCategory();
        return "redirect:/tea-product/" + categoryId;
    }

    @RequestMapping(value = "/details/{productId}", method = RequestMethod.GET)
    public String getDetailsProduct(Model model, @PathVariable("productId")int productId, Locale locale){
        model.addAttribute("product", productDAO.getProduct(productId));
        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("translatedCategory", categoryDAO.getCategoryById(locale.getLanguage(), productDAO.getProduct(productId).getCategory()).getTranslation());
        return "integrated:productDetails";
    }

}
