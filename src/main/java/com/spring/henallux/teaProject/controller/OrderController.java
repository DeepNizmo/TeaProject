package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.dataAccess.dao.OrderDataAccess;
import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.model.Order;
import com.spring.henallux.teaProject.model.User;
import com.spring.henallux.teaProject.service.Constants;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.Date;

@Controller
@RequestMapping(value="/order")
@SessionAttributes({Constants.CURRENT_CART, Constants.CURRENT_ORDER})
public class OrderController {
    private OrderDataAccess orderDAO;

    public OrderController(OrderDataAccess orderDAO) {
        this.orderDAO = orderDAO;
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() {return new Cart();}

    @ModelAttribute(Constants.CURRENT_ORDER)
    public Order order() {return new Order();}

    @RequestMapping (method = RequestMethod.GET)
    public String order(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        return "integrated:order";
    }

    @RequestMapping (value = "/confirmOrder", method = RequestMethod.POST)
    public String saveOrder(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart, @ModelAttribute(value = Constants.CURRENT_ORDER) Order order, Authentication authentication) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute(Constants.CURRENT_ORDER, order);
        order.setDate(new Date());
        order.setUser((User) authentication.getPrincipal());
        Order orderSaved = orderDAO.saveOrder(cart, order);
        order.setId(orderSaved.getId());
        return "redirect:/payment";
    }

    @RequestMapping (value = "/paymentSuccess", method = RequestMethod.GET)
    public String success(@ModelAttribute(value = Constants.CURRENT_CART) Cart cart, @ModelAttribute(value = Constants.CURRENT_ORDER) Order order) {
        order.setPaid(true);
        Order orderUpdated = orderDAO.saveOrder(cart, order);
        order.setId(null);
        cart.getItems().clear();
        return "redirect:/home";
    }

    @RequestMapping (value = "/paymentFailed", method = RequestMethod.GET)
    public String fail() {
        return "redirect:/cart";
    }
}
