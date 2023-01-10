package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getProductsByCategory(String category);
    Product getProduct(int idProduct);
}
