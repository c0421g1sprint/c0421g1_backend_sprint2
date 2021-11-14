package com.codegym.services.impls;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.repositories.IFoodAndDrinkRepository;
import com.codegym.services.IFoodAndDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodAndDrinkServiceImpl implements IFoodAndDrinkService {
    @Autowired
    IFoodAndDrinkRepository foodAndDrinkRepository;

    @Override
    public void saveCategory(Category category) {
//        foodAndDrinkRepository.saveCategory();
    }

    @Override
    public void updateCategory(Category category) {

    }
}
