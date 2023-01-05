package com.spring.henallux.teaProject.controller;

import com.spring.henallux.teaProject.service.Constants;
import com.spring.henallux.teaProject.model.User;
import com.spring.henallux.teaProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value= "/inscription")
@SessionAttributes({Constants.CURRENT_USER})
public class InscriptionController {

    private UserService userService;
    private MessageSource messageSource;
    @Autowired
    public InscriptionController(UserService userService,MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public User user() {
        return new User();
    }

    @RequestMapping(method= RequestMethod.GET)
    public String get (Model model) {
        model.addAttribute("currentUser", user());
        return "integrated:inscription";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String post(Model model, @Valid @ModelAttribute(value = Constants.CURRENT_USER)  User user, final BindingResult bindingResult, Locale locale) {
        if (!bindingResult.hasErrors()) {
            if(user.getPassword().equals(user.getConfirmPassword())) {
                if(userService.checkUserExist(user)) model.addAttribute("userExist", messageSource.getMessage("userExist", new Object[0], locale));
                else {
                    user = userService.saveUser(user);
                    return "redirect:/login";
                }
            } else model.addAttribute("passwordDontMatch",messageSource.getMessage("passwordDontMatch", new Object[0], locale));
        }
        return "integrated:inscription";
    }
}