package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.dataAccess.entity.ProductEntity;
import com.spring.henallux.teaProject.dataAccess.entity.ReductionEntity;
import com.spring.henallux.teaProject.dataAccess.repository.ProductRepository;
import com.spring.henallux.teaProject.dataAccess.repository.ReductionRepository;
import com.spring.henallux.teaProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.teaProject.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional //il faut peut être juste le mettre sur getProductsByCategory
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

        for (ProductEntity productEntity : productEntities) { //passe en revue tout les produits
            int iEntity = 0;
            while (iEntity < reductionEntities.size() - 1 && !reductionEntities.get(iEntity).getProduct().getId().equals(productEntity.getId())) { // tant qu'il n'a pas trouvé de réduction sur le produit
                iEntity++;
            }
            Product product = providerConverter.productEntityToProductModel(productEntity);
            if (reductionEntities.get(iEntity).getProduct().getId().equals(productEntity.getId())) { // si il trouve la réduction, il calcule le prix réduit
                Integer percentage = reductionEntities.get(iEntity).getPromotion().getPercentage();
                product.setPromotion(percentage);
            }
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getProduct(int idProduct) {
        ProductEntity productEntity = productRepository.findById(idProduct);
        List<ReductionEntity> reductionEntities = reductionRepository.findByPromotion_StartDateLessThanEqualAndPromotion_EndDateGreaterThanEqual(new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime()));

        if(productEntity == null) return null;
        Product product = providerConverter.productEntityToProductModel(productEntity);

        int iEntity = 0;
        while (iEntity < reductionEntities.size() - 1 && !reductionEntities.get(iEntity).getProduct().getId().equals(productEntity.getId())) { // tant qu'il n'a pas trouvé de réduction sur le produit
            iEntity++;
        }
        if (reductionEntities.get(iEntity).getProduct().getId().equals(productEntity.getId())) { // si il trouve la réduction, il calcule le prix réduit
            Integer promotion = reductionEntities.get(iEntity).getPromotion().getPercentage();
            product.setPromotion(promotion);
        }
        return product;
    }
}
