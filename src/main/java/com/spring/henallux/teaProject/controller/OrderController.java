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
@SessionAttributes({Constants.CURRENT_CART})
public class OrderController {
    private OrderDataAccess orderDAO;
    private UserDataAccess userDAO; // TEMPORAIRE

    public OrderController(OrderDataAccess orderDAO, UserDataAccess userDAO) {
        this.orderDAO = orderDAO;
        this.userDAO = userDAO;
    }

    @ModelAttribute(Constants.CURRENT_CART)
    public Cart cart() {return new Cart();}

    @ModelAttribute("order")
    public Order order() {return new Order();}

    @RequestMapping (method = RequestMethod.GET)
    public String order(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart) { //TODO : prevoir que si un client va sur la page order alors que le panier est vide, il est refirigé vers une autre page pour lui dire que son panier est vide.
        model.addAttribute(Constants.CURRENT_CART, cart);
        //si vide redirect card
        return "integrated:order";
    }

    @RequestMapping (value = "/confirmOrder", method = RequestMethod.POST)
    public String saveOrder(Model model, @ModelAttribute(value = Constants.CURRENT_CART) Cart cart, @ModelAttribute(value = "order") Order order) {
        model.addAttribute(Constants.CURRENT_CART, cart);
        model.addAttribute("order", order);
        order.setDate(new Date()); //pas ouf je pense, mais j'ai pas réusssis à le faire passer dans le form
        User user = userDAO.findByUsername("user1");
        order.setUser(user);
        orderDAO.saveOrder(cart, order);
        //if ok redirect payment else (si probleme queqlonque pas de co parexemple) : redirect orderError
        return "redirect:/payment";
    }
}
