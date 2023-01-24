package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.teaProject.dataAccess.entity.ReductionEntity;
import com.spring.henallux.teaProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.teaProject.dataAccess.repository.ReductionRepository;
import com.spring.henallux.teaProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.teaProject.model.Product;
import com.spring.henallux.teaProject.model.Promotion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductDAO implements ProductDataAccess {
    private ProductRepository productRepository;
    private ProviderConverter providerConverter;
    private ReductionRepository reductionRepository;

    public ProductDAO(ProductRepository productRepository, ProviderConverter providerConverter, ReductionRepository reductionRepository) {
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;
        this.reductionRepository = reductionRepository;
    }


    @Override
    public ArrayList<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        ArrayList<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            Product product = providerConverter.productEntityToProductModel(productEntity);
            products.add(product);
        }
        return products;
    }

    @Override
    public ArrayList<Product> getProductsByCategory(String category) {

        List<ProductEntity> productEntities = productRepository.findByCategory(category);
        List<ReductionEntity> reductionEntities = reductionRepository.findByPromotion_StartDateLessThanEqualAndPromotion_EndDateGreaterThanEqual(new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime()));
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Integer> promotions = new ArrayList<>();;

        for (ProductEntity productEntity : productEntities) {
            Product product = providerConverter.productEntityToProductModel(productEntity);
            for (ReductionEntity reductionEntity : reductionEntities) {
                if (reductionEntity.getProduct().getId() == productEntity.getId()) {
                    promotions.add(reductionEntity.getPromotion().getPercentage());
                }
            }
            product.setPromotions(promotions);
            products.add(product);
            promotions = new ArrayList<>();
        }
        return products;
    }

    @Override
    public Product getProduct(int idProduct) {
        ProductEntity productEntity = productRepository.findById(idProduct);
        List<ReductionEntity> reductionEntities = reductionRepository.findByPromotion_StartDateLessThanEqualAndPromotion_EndDateGreaterThanEqual(new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime()));
        ArrayList<Integer> promotions = new ArrayList<>();

        if(productEntity == null) return null;
        Product product = providerConverter.productEntityToProductModel(productEntity);

        for (ReductionEntity reductionEntity : reductionEntities) {
            if (reductionEntity.getProduct().getId() == productEntity.getId()) {
                promotions.add(reductionEntity.getPromotion().getPercentage());
            }
        }
        product.setPromotions(promotions);
        return product;
    }
}
