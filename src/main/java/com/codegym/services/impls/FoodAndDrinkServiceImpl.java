package com.codegym.services.impls;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.codegym.repositories.IFoodAndDrinkRepository;
import com.codegym.services.IFoodAndDrinkService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FoodAndDrinkServiceImpl implements IFoodAndDrinkService {
    @Autowired // BaoHG
    private IFoodAndDrinkRepository foodAndDrinkRepository;


    @Override // BaoHG
    public List<FoodAndDrink> findFoodCategoryId(int id) {
        return this.foodAndDrinkRepository.findFoodTheoCategoryById(id);
    }


    @Override // BaoHG
    public List<FoodAndDrink> listAll( ) {
        return this.foodAndDrinkRepository.findAllFood();
    }


    @Override // BaoHG
    public Optional<FoodAndDrink> findFoodById(int id) {
        return this.foodAndDrinkRepository.findFoodById(id);
    }

    @Override //BaoHG
    public List<FoodAndDrink> searchFoodAndDrink(String name) {
        return this.foodAndDrinkRepository.searchFood(name);
    }
}
