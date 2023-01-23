package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.model.CartItem;
import com.spring.henallux.teaProject.service.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({Constants.CURRENT_CART})
public class CartController {
    private MessageSource messageSource;

    @Autowired
    public CartController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() {return new Cart();}

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(value = Constants.CURRENT_CART)Cart cart) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute("items", cart.getItems().values());
        if (!model.containsAttribute("cartItem")) {
            model.addAttribute("cartItem", new CartItem());
        }
        return "integrated:cart";
    }

    @RequestMapping (value = "/removeItem", method = RequestMethod.POST)
    public String removeItem(@ModelAttribute(value = "cartItem") CartItem item, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        cart.removeProduct(item.getId());
        return "redirect:/cart";
    }

    @RequestMapping (value = "/setQuantity", method = RequestMethod.POST)
    public String setQuantity(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart, @Valid @ModelAttribute(value = "cartItem") CartItem item, final BindingResult errors, RedirectAttributes attr, Locale locale) {
        if (item.getQuantity() == null) {
            attr.addFlashAttribute("isNotDigitMessage", messageSource.getMessage("isNotDigit", new Object[0], locale));
        } else {
            if (!errors.hasErrors()) {
                cart.setQuantityCart(item.getId(), item.getQuantity());
            } else {
                attr.addFlashAttribute("org.springframework.validation.BindingResult.cartItem", errors);
                attr.addFlashAttribute("cartItem", item);
            }
        }
        return "redirect:/cart";
    }
}
