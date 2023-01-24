package com.spring.henallux.teaProject.model;

import java.util.ArrayList;

public class Product {
    private Integer id;
    private String name;
    private Double unitPrice;
    private String details;
    private String category;
    private ArrayList<Integer> promotions;

    public Product() {
    }

    public Product(Integer id, String name, Double actualPrice, String details, String category) {
        this.id = id;
        this.name = name;
        this.unitPrice = actualPrice;
        this.details = details;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Integer> getPromotions() {
        return promotions;
    }

    public void setPromotions(ArrayList<Integer> promotions) {
        this.promotions = promotions;
    }

    public Double getActualPrice() {
        Double reducedPrice = unitPrice;
        for (Integer promotion: promotions){
            reducedPrice *= (1 - ((double)promotion / 100));

        }
        return reducedPrice;
    }
}
