package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.dataAccess.dao.ProductDAO;
import com.spring.henallux.teaProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.model.CartItem;
import com.spring.henallux.teaProject.service.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/tea-product")
@SessionAttributes({Constants.CURRENT_CART})
public class ProductController {
    private ProductDataAccess productDAO;

    @Autowired
    public void getProducts(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() {return new Cart();}

    @RequestMapping (method = RequestMethod.GET)
    public String home(Model model, @RequestParam(required = true, defaultValue = "black") String category, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute("productsList", productDAO.getProductsByCategory(category));
        model.addAttribute("cartItem", new CartItem());
        return "integrated:product";
    }

    @RequestMapping (value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(Model model, @ModelAttribute(value = "cartItem") CartItem item, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        cart.addProduct(item.getId(), item);
        String categoryId = item.getCategory();
        return "redirect:/tea-product?category=" + categoryId;
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public String getDetailsProduct(Model model, @PathVariable("productId")int productId){
        model.addAttribute("product", productDAO.getProduct(productId));
        return "integrated:productDetails";
    }

}
