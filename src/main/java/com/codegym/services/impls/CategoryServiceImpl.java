package com.codegym.services.impls;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.repositories.ICategoryRepository;
import com.codegym.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    //LamNT create category
    @Override
    public void saveCategory(Category category) {
        categoryRepository.saveCategory(category.getCategoryName(), category.getCategoryCode());
    }

    //LamNT update category
    @Override
    public void updateCategory(Category category) {
        categoryRepository.updateCategory(category.getCategoryName(), category.getCategoryCode(), category.getCategoryId());
    }

    @Override
    public Page<Category> viewAllCategory(Pageable pageable, String code, String name) {
        return categoryRepository.viewAllCategoryByQuery(pageable, code, name);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteCategory(id);
    }

    @Override
    public Category detailCategory(Integer id) {
        return categoryRepository.viewDetailCategory(id);
    }
}
