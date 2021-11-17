package com.codegym.services.impls;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.repositories.ICategoryRepository;
import com.codegym.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl  implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> listAll() {
        return this.iCategoryRepository.listAllNameCategory();
    }
}
