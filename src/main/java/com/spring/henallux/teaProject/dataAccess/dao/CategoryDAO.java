package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.teaProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.teaProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.teaProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess{

    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter providerConverter) {
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }


    @Override
    public ArrayList<String> getCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findByLanguageId("fr"); // TODO : lier la langue des catégorie avec le choix de la langue sur la page web
        ArrayList<String> categories = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            Category category = providerConverter.categoryEntityToCategoryModel(categoryEntity);
            categories.add(category.getTranslation());
        }
        return categories;
    }
}
