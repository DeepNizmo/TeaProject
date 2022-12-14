package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.dataAccess.dao.OrderDataAccess;
import com.spring.henallux.teaProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.model.Order;
import com.spring.henallux.teaProject.model.User;
import com.spring.henallux.teaProject.service.Constants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value="/order")
@SessionAttributes({Constants.CURRENT_CART, Constants.CURRENT_USER})
public class OrderController {
    private OrderDataAccess orderDAO;
    private UserDataAccess userDAO;

    public OrderController(OrderDataAccess orderDAO, UserDataAccess userDAO) {
        this.orderDAO = orderDAO;
        this.userDAO = userDAO;
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() {return new Cart();}

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {return new User();}

    @ModelAttribute("order")
    public Order order() {return new Order();}

    @RequestMapping (method = RequestMethod.GET)
    public String order(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        return "integrated:order";
    }

    @RequestMapping (value = "/confirmOrder", method = RequestMethod.POST)
    public String saveOrder(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart, @ModelAttribute(value = "order") Order order) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute("order", order);
        order.setDate(new Date());
        User user = userDAO.findByUsername("user1");
        order.setUser(user);
        orderDAO.saveOrder(cart, order);
        return "redirect:/payment";
    }

    @RequestMapping (value = "/paymentSuccess", method = RequestMethod.GET)
    public String success(@ModelAttribute(value = Constants.CURRENT_CART) Cart cart, @ModelAttribute(value = "order") Order order) {
        order.setDate(new Date());
        User user = userDAO.findByUsername("user1");
        order.setPaid(true);
        order.setUser(user);
        orderDAO.saveOrder(cart, order);
        cart.getItems().clear();
        return "redirect:/home";
    }

    @RequestMapping (value = "/paymentFailed", method = RequestMethod.GET)
    public String fail() {
        return "redirect:/cart";
    }
}
