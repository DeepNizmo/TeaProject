package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.teaProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.model.CartItem;
import com.spring.henallux.teaProject.model.Product;
import com.spring.henallux.teaProject.model.Category;
import com.spring.henallux.teaProject.service.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value="/tea-product")
@SessionAttributes({Constants.CURRENT_CART})
public class ProductController {
    private ProductDataAccess productDAO;
    private MessageSource messageSource;

    @Autowired
    public void getProducts(ProductDAO productDAO,MessageSource messageSource) {

        this.productDAO = productDAO;
        this.messageSource=messageSource;
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() {return new Cart();}

    @RequestMapping (value = "/{categoryId}", method = RequestMethod.GET)
    public String home(Model model, @PathVariable("categoryId")String categoryId, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart,Locale locale) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        ArrayList<Product> products=productDAO.getProductsByCategory(categoryId);
        model.addAttribute("productsList",products);
        model.addAttribute("cartItem", new CartItem());
        if(products.isEmpty()) {
            model.addAttribute("message", messageSource.getMessage("errorCategory", new Object[0],locale));
            return "integrated:error";
        }
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
        Product product=productDAO.getProduct(productId);
        model.addAttribute("product", product);
        model.addAttribute("cartItem", new CartItem());
        if(product == null)  {
            model.addAttribute("message", messageSource.getMessage("errorProduct", new Object[0],locale));
            return "integrated:error";
        }
        return "integrated:productDetails";
    }

}