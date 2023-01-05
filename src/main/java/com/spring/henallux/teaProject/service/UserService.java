package com.spring.henallux.teaProject.service;

import com.spring.henallux.teaProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.teaProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDataAccess userDAO;

    @Autowired
    public UserService(UserDataAccess userDAO) {
        this.userDAO = userDAO;
    }

    public User saveUser(User user) {
        user.setPassword((user.getPassword()));
        return userDAO.save(user);
    }
    public boolean checkUserExist(User user) {
        return userDAO.findByUsername(user.getUsername()) != null;
    }
}
