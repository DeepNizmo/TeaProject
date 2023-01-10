package com.spring.henallux.teaProject.dataAccess.repository;

import com.spring.henallux.teaProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.teaProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.teaProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Product> {
    List<ProductEntity> findByCategory(String category);
    ProductEntity findById(int id);
}