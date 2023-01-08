package com.spring.henallux.teaProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "reduction")
public class ReductionEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "promotion", referencedColumnName = "id")
    @ManyToOne
    private PromotionEntity promotion;

    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne
    private ProductEntity product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
