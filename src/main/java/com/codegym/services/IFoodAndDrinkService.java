package com.codegym.services;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.food_and_drink.FoodAndDrink;

import java.util.List;

public interface IFoodAndDrinkService {

    //LamNT create category
    void saveCategory(Category category);

    //LamNT update category
    void updateCategory(Category category);

    //LamNT create foodAndDrink
    void createFoodAndDrink(FoodAndDrink foodAndDrink);

    //LamNT update foodAndDrink
    void updateFoodAndDrink(FoodAndDrink foodAndDrink);


    //HaNTT: get top 5 new food
    List<FoodAndDrink> topFiveNewProduct ();

    //HaNTT: get top 5 popular food
    List<FoodAndDrink> topFivePopularProduct ();
}
