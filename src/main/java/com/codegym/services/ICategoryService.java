package com.codegym.services;

import com.codegym.entity.food_and_drink.Category;

import java.util.List;

public interface ICategoryService {

    //LamNT create category
    void saveCategory(Category category);

    //LamNT update category
    void updateCategory(Category category);

    //LamNT find all category
    List<Category> findAllCategory();

    //LamNT find category By Id
    Category findCategoryById(int id);
}
