package com.spring.henallux.teaProject.dataAccess.repository;

import com.spring.henallux.teaProject.dataAccess.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    List<CategoryEntity> findByLanguageId(String language);
    CategoryEntity findByLanguageIdAndCategoryId(String language, String category);
}
