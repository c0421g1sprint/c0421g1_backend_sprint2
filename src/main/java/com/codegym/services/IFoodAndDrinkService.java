package com.codegym.services;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IFoodAndDrinkService {
    List<FoodAndDrink> findFoodCategoryId(int id);

    List<FoodAndDrink> listAll();

    Optional<FoodAndDrink> findFoodById(int id);

    List<FoodAndDrink> searchFoodAndDrink(String name);
}
