package com.spring.henallux.teaProject.dataAccess.util;

import com.spring.henallux.teaProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.teaProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.teaProject.dataAccess.entity.ReductionEntity;
import com.spring.henallux.teaProject.model.Category;
import com.spring.henallux.teaProject.model.Product;
import com.spring.henallux.teaProject.model.Reduction;
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

    public Reduction reductionEntityToReductionModel(ReductionEntity reductionEntity) {
        Reduction reduction = mapper.map(reductionEntity, Reduction.class);
        return reduction;
    }
}
