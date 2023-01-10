package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.model.Category;

import java.util.ArrayList;

public interface CategoryDataAccess {
    ArrayList<Category> getCategories(String language);
}
