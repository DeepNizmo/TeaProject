package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.model.User;

import java.util.ArrayList;

public interface UserDataAccess {

    User save(User user);

    User findByUsername(String username);
    User findByUsernameOrEmail(String username, String email);

    ArrayList<User> getAllUser();
}
