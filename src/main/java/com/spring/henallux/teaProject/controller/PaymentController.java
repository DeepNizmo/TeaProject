package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.service.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="/payment")
@SessionAttributes({Constants.CURRENT_CART})
public class PaymentController {

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() {return new Cart();}

    @RequestMapping(method = RequestMethod.GET)
    public String pay(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        //payer
        //clear cart
        return "integrated:payment";
    }

    @RequestMapping (value = "/send", method = RequestMethod.POST) //peut être pas utile.
    public String send(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        //si payé go paymentSuccess et isPaid True DB sinon erreur
        return "redirect:/paymentSuccess";
    }
}
