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

        for (ProductEntity productEntity : productEntities) { //passe en revue tout les produits
//            System.out.println("dans le for (produit) : " + productEntity.getName() + "\n");
//            System.out.println("dans le for (produit) : " + productEntity.getId() + "\n");

            int iEntity = 0;
            while (iEntity < reductionEntities.size() - 1 && !reductionEntities.get(iEntity).getProduct().getId().equals(productEntity.getId())) { // tant qu'il n'a pas trouvé de réduction sur le produit
//                System.out.println("dans la boucle : " + reductionEntities.get(iEntity).getProduct().getName() + "\n");
//                System.out.println(reductionEntities.get(iEntity).getProduct().getId());
                iEntity++;
            }
//            System.out.println("taille = " + reductionEntities.size() + "\n");
//            System.out.println("Ientity = " + iEntity + "\n");
            Product product = providerConverter.productEntityToProductModel(productEntity);
            if (reductionEntities.get(iEntity).getProduct().getId().equals(productEntity.getId())) { // si il trouve la réduction, il calcule le prix réduit
//                System.out.println("promo : " + reductionEntities.get(iEntity).getPromotion().getPercentage() + "%\n");
//                System.out.println("produitPromo : " + reductionEntities.get(iEntity).getProduct().getName()+ "\n");
//                System.out.println("produit : " + productEntity.getName()+ "\n");
                Double reducedPrice = (1 - ((double)reductionEntities.get(iEntity).getPromotion().getPercentage() / 100)) * productEntity.getUnitPrice();
//                System.out.println("prix reduit = " + reducedPrice);
                product.setReducedPrice(reducedPrice);
            }
            products.add(product);
        }
//        System.out.println("[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]");
        return products;
    }

    @Override
    public Product getProduct(int idProduct) {
        ProductEntity productEntity = productRepository.findById(idProduct);
        if(productEntity == null) return null;
        Product product = providerConverter.productEntityToProductModel(productEntity);
        return product;
    }
}