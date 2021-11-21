package com.codegym.services.impls;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.codegym.repositories.IFoodAndDrinkRepository;
import com.codegym.services.IFoodAndDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class FoodAndDrinkServiceImpl implements IFoodAndDrinkService {

    @Autowired
    IFoodAndDrinkRepository foodAndDrinkRepository;

    //LamNT create fad
    @Override
    public void createFoodAndDrink(FoodAndDrink foodAndDrink) {
        foodAndDrinkRepository.createFoodAndDrink(foodAndDrink.getFadCode(), foodAndDrink.getFadImage(),
                foodAndDrink.getFadName(), foodAndDrink.getFadPrice(), foodAndDrink.getCategory().getCategoryId());
    }

    //LamNT update fad
    @Override
    public void updateFoodAndDrink(FoodAndDrink foodAndDrink) {
        foodAndDrinkRepository.updateFoodAndDrink(foodAndDrink.getFadCode(), foodAndDrink.getFadImage(), foodAndDrink.getFadName(),
                foodAndDrink.getFadPrice(), foodAndDrink.getCategory().getCategoryId(), foodAndDrink.getFadId());
    }

    //LamNT finById
    @Override
    public FoodAndDrink findFoodAndDrinkById(int id) {
        return foodAndDrinkRepository.findFoodAndDrinkById(id);
    }
}
