package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.teaProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.teaProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.teaProject.model.Category;
import org.apache.tomcat.util.http.parser.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
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
    public ArrayList<Category> getCategories(String language) {
        List<CategoryEntity> categoryEntities = categoryRepository.findByLanguageId(language);
        ArrayList<Category> categories = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            Category category = providerConverter.categoryEntityToCategoryModel(categoryEntity);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public Category getCategoryById(String language, String category) {
        return providerConverter.categoryEntityToCategoryModel(categoryRepository.findByLanguageIdAndCategoryId(language, category));
    }
}
