package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.teaProject.dataAccess.repository.CategoryRepository;
import com.spring.henallux.teaProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.teaProject.model.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CategoryDAOTest {

    private CategoryDataAccess translationCategoryDao;

    @Mock
    private CategoryRepository translationCategoryRepository;


    @BeforeEach
    void setUp() {
        translationCategoryDao = new CategoryDAO(translationCategoryRepository, new ProviderConverter());
    }

    public List<CategoryEntity> mockedCategoriesEntitiesEn() {
        List<CategoryEntity> mockedEntities = new ArrayList<>();

        CategoryEntity black = new CategoryEntity();
        black.setId(1);
        black.setCategoryId("black");
        black.setLanguageId("en");
        black.setTranslation("black");

        CategoryEntity green = new CategoryEntity();
        green.setId(2);
        green.setCategoryId("green");
        green.setLanguageId("en");
        green.setTranslation("green");

        CategoryEntity oolong = new CategoryEntity();
        oolong.setId(3);
        oolong.setCategoryId("oolong");
        oolong.setLanguageId("en");
        oolong.setTranslation("oolong");

        CategoryEntity rooibos = new CategoryEntity();
        rooibos.setId(4);
        rooibos.setCategoryId("rooibos");
        rooibos.setLanguageId("en");
        rooibos.setTranslation("rooibos");

        CategoryEntity white = new CategoryEntity();
        white.setId(5);
        white.setCategoryId("white");
        white.setLanguageId("en");
        white.setTranslation("white");

        mockedEntities.add(black);
        mockedEntities.add(green);
        mockedEntities.add(oolong);
        mockedEntities.add(rooibos);
        mockedEntities.add(white);

        return mockedEntities;
    }

    public List<CategoryEntity> mockedCategoriesEntitiesFr() {
        List<CategoryEntity> mockedEntities = new ArrayList<>();

        CategoryEntity black = new CategoryEntity();
        black.setId(6);
        black.setCategoryId("black");
        black.setLanguageId("fr");
        black.setTranslation("noir");

        CategoryEntity green = new CategoryEntity();
        green.setId(7);
        green.setCategoryId("green");
        green.setLanguageId("fr");
        green.setTranslation("vert");

        CategoryEntity oolong = new CategoryEntity();
        oolong.setId(8);
        oolong.setCategoryId("oolong");
        oolong.setLanguageId("fr");
        oolong.setTranslation("oolong");

        CategoryEntity rooibos = new CategoryEntity();
        rooibos.setId(9);
        rooibos.setCategoryId("rooibos");
        rooibos.setLanguageId("fr");
        rooibos.setTranslation("rooibos");

        CategoryEntity white = new CategoryEntity();
        white.setId(10);
        white.setCategoryId("white");
        white.setLanguageId("fr");
        white.setTranslation("blanc");

        mockedEntities.add(black);
        mockedEntities.add(green);
        mockedEntities.add(oolong);
        mockedEntities.add(rooibos);
        mockedEntities.add(white);

        return mockedEntities;
    }

    @Test
    @DisplayName("Test : English categories")
    public void englishCategories() {
        String expectedBlack = "black";
        String expectedGreen = "green";
        String expectedOolong = "oolong";
        String expectedRooibos = "rooibos";
        String expectedWhite = "white";

        when(translationCategoryRepository.findByLanguageId("en")).thenReturn(mockedCategoriesEntitiesEn());

        ArrayList<Category> translationsCategories = translationCategoryDao.getCategories("en");

        Assert.assertEquals(mockedCategoriesEntitiesFr().size(),translationsCategories.size());
        Assert.assertEquals( expectedBlack , translationsCategories.get(0).getTranslation());
        Assert.assertEquals( expectedGreen , translationsCategories.get(1).getTranslation());
        Assert.assertEquals( expectedOolong , translationsCategories.get(2).getTranslation());
        Assert.assertEquals( expectedRooibos , translationsCategories.get(3).getTranslation());
        Assert.assertEquals( expectedWhite , translationsCategories.get(4).getTranslation());

    }

    @Test
    @DisplayName("Test : French categories")
    public void frenchCategories() {
        String expectedBlack = "noir";
        String expectedGreen = "vert";
        String expectedOolong = "oolong";
        String expectedRooibos = "rooibos";
        String expectedWhite = "blanc";

        when(translationCategoryRepository.findByLanguageId("fr")).thenReturn(mockedCategoriesEntitiesFr());

        ArrayList<Category> translationsCategories = translationCategoryDao.getCategories("fr");

        Assert.assertEquals(mockedCategoriesEntitiesFr().size(),translationsCategories.size());
        Assert.assertEquals( expectedBlack , translationsCategories.get(0).getTranslation());
        Assert.assertEquals( expectedGreen , translationsCategories.get(1).getTranslation());
        Assert.assertEquals( expectedOolong , translationsCategories.get(2).getTranslation());
        Assert.assertEquals( expectedRooibos , translationsCategories.get(3).getTranslation());
        Assert.assertEquals( expectedWhite , translationsCategories.get(4).getTranslation());

    }
}