package com.spring.henallux.teaProject.model;

import java.util.HashMap;

public class Cart {
    private HashMap<Integer, CartItem> items;

    public Cart() {
        items = new HashMap<>();
    }

    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(HashMap<Integer, CartItem> items) {
        this.items = items;
    }

    public void addProduct(int productId, CartItem cartItem) {
        if(items.containsKey(productId)) {
            items.get(productId).setQuantity(items.get(productId).getQuantity() + 1);
        } else {
            items.put(productId, cartItem);
        }
    }



    public void removeProduct(int productId) {
        items.remove(productId);
    }

    public void setQuantityCart(int productId, int quantity) {
        items.get(productId).setQuantity(quantity);
    }
}
