package com.spring.henallux.teaProject.model;

public class Product {
    private Integer id;
    private String name;
    private Double unitPrice;
    private String details;
    private String category;
    private Double reducedPrice;

    public Product() {
    }

    public Product(Integer id, String name, Double unitPrice, String details, String category, Double reducedPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.details = details;
        this.category = category;
        this.reducedPrice = reducedPrice;
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

    public Double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(Double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public Double getActualPrice() {
        return reducedPrice != null ? reducedPrice : unitPrice;
    }
}
