package com.spring.henallux.teaProject.model;

public class OrderLine {
    private Integer id;
    private Order order;
    private Product product;
    private Integer quantity;
    private Double orderPirce;

    public OrderLine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getOrderPirce() {
        return orderPirce;
    }

    public void setOrderPirce(Double orderPirce) {
        this.orderPirce = orderPirce;
    }
}
