package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.model.Cart;
import com.spring.henallux.teaProject.model.Order;

public interface OrderDataAccess {
    Order saveOrder(Cart cart, Order order);
}
