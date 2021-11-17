package com.codegym.services;

import com.codegym.entity.food_and_drink.Category;

public interface ICategoryService {

    //LamNT create category
    void saveCategory(Category category);

    //LamNT update category
    void updateCategory(Category category);
}
