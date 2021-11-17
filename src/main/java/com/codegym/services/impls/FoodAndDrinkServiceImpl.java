package com.codegym.services.impls;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.codegym.repositories.IFoodAndDrinkRepository;
import com.codegym.services.IFoodAndDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class FoodAndDrinkServiceImpl implements IFoodAndDrinkService {
    @Autowired
    private IFoodAndDrinkRepository foodAndDrinkRepository;


    @Override
    public List<FoodAndDrink> findFoodCategoryId(int id) {
//        return this.foodAndDrinkRepository.findFoodById(id);
        return this.foodAndDrinkRepository.findFoodTheoCategoryById(id);
    }




    @Override
    public List<FoodAndDrink> listAll() {
        return this.foodAndDrinkRepository.findAll();
    }


    @Override
    public Optional<FoodAndDrink> findFoodById(int id) {
        return this.foodAndDrinkRepository.findFoodById(id);
    }
}
