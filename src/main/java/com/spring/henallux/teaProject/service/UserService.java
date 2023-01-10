package com.spring.henallux.teaProject.service;

import com.spring.henallux.teaProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.teaProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDataAccess userDAO;

    @Autowired
    public UserService(UserDataAccess userDAO) {
        this.userDAO = userDAO;
    }

    public User saveUser(User user) {
        user.setAuthorities("ROLE_USER");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        user.setPassword((user.getPassword()));
        return userDAO.save(user);
    }
    public boolean checkUserExist(User user) {
        return userDAO.findByUsername(user.getUsername()) != null;
    }
}
