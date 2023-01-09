package com.spring.henallux.teaProject.dataAccess.util;

import com.spring.henallux.teaProject.dataAccess.entity.*;
import com.spring.henallux.teaProject.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        Category category = mapper.map(categoryEntity, Category.class);
        return category;
    }

    public Product productEntityToProductModel(ProductEntity productEntity) {
        Product product = mapper.map(productEntity, Product.class);
        return product;
    }

    public ProductEntity productModelToProductEntity(Product product) {
        ProductEntity productEntity = mapper.map(product, ProductEntity.class);
        return productEntity;
    }
    public User userEntityToUserModel(UserEntity userEntity) {
        User user = mapper.map(userEntity, User.class);
        return user;
    }

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        return userEntity;
    }

    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine) {
        OrderLineEntity orderLineEntity = mapper.map(orderLine, OrderLineEntity.class);
        return orderLineEntity;
    }

    public OrderEntity orderModelToOrderEntity(Order order) {
        OrderEntity orderEntity = mapper.map(order, OrderEntity.class);
        return orderEntity;
    }

    public Reduction reductionEntityToReductionModel(ReductionEntity reductionEntity) {
        Reduction reduction = mapper.map(reductionEntity, Reduction.class);
        return reduction;
    }
}
