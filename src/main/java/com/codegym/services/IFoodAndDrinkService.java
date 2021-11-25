package com.codegym.services;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IFoodAndDrinkService {
    List<FoodAndDrink> findFoodCategoryId(int id); //  BaoHG

    List<FoodAndDrink> listAll(); // BaoHG

    Optional<FoodAndDrink> findFoodById(int id); //BaoHG

    List<FoodAndDrink> searchFoodAndDrink(String name); // BaoHG
}
