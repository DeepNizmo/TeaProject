package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.teaProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.teaProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.teaProject.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductDAO implements ProductDataAccess {
    private ProductRepository productRepository;
    private ProviderConverter providerConverter;

    public ProductDAO(ProductRepository productRepository, ProviderConverter providerConverter) {
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;
    }


    @Override
    public ArrayList<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        ArrayList<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            System.out.println(productEntity.getName());
            Product product = providerConverter.productEntityToProductModel(productEntity);
            System.out.println(product.getName());
            products.add(product);
        }
        return products;
    }

    @Override
    public ArrayList<Product> getProductsByCategory(String category) {
        List<ProductEntity> productEntities = productRepository.findByCategory(category);
        ArrayList<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            Product product = providerConverter.productEntityToProductModel(productEntity);
            products.add(product);
            System.out.println(product.getName());
        }
        return products;
    }
}
