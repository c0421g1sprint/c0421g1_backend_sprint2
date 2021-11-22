package com.codegym.services;

import com.codegym.entity.food_and_drink.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    //LamNT create category
    void saveCategory(Category category);

    //LamNT update category
    void updateCategory(Category category);

    //LinhDN view all category
    Page<Category> viewAllCategory(Pageable pageable, String code, String name);

    //LinhDN delete category
    void deleteCategory(Integer id);

    //LinhDN delete category
    Category detailCategory(Integer id);

    //BaoHG
    List<Category> listAll();
}
