package com.spring.henallux.teaProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_line")
public class OrderLineEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "`order`", referencedColumnName = "id")
    @ManyToOne
    private OrderEntity order;

    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne
    private ProductEntity product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "product_price")
    private Double productPrice;

    public OrderLineEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double orderPrice) {
        this.productPrice = orderPrice;
    }
}
