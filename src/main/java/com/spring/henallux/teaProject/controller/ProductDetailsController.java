package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.model.CartItem;
import com.spring.henallux.teaProject.service.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/tea-product/details")
@SessionAttributes({Constants.CURRENT_CART})
public class ProductDetailsController {
    @RequestMapping (value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(@ModelAttribute(value = "cartItem") CartItem item, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        cart.addProduct(item.getId(), item);
        int productId = item.getId();
        return "redirect:/tea-product/details/" + productId;
    }
}
