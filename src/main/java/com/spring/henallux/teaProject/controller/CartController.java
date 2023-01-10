package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.dataAccess.dao.ProductDataAccess;
import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.model.CartItem;
import com.spring.henallux.teaProject.service.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_CART})
public class CartController {

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() {return new Cart();}

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CURRENT_CART)Cart cart) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("items", cart.getItems().values());
        return "integrated:cart";
    }

    @RequestMapping (value = "/removeItem", method = RequestMethod.POST)
    public String removeItem(@ModelAttribute(value = "cartItem") CartItem item, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        cart.removeProduct(item.getId());
        return "redirect:/cart";
    }

    @RequestMapping (value = "/setQuantity", method = RequestMethod.POST)
    public String setQuantity(@ModelAttribute(value = "cartItem") CartItem item, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        cart.setQuantityCart(item.getId(), item.getQuantity());
        return "redirect:/cart";
    }
}
