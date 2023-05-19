package com.luongvandat.services;

import com.luongvandat.entities.Category;

import java.util.List;

public interface CategoryServices {

    List<Category> findAll();
    Category findOneById(String id);

    Category add(Category category);

    Category deleteById(String id);

    Category update(Category category);

    Category findCategoryByCategoryName(String name);
    List<Category> findCategoriesBy();
    List<Category> find10Categories(int offset);

    List<Category> searchCategoriesByCategoryName(String categoryName, int offset);
    int countCategoriesBy();
    Category findCategoryByCategoryNameIgnoreCase(String name);
}