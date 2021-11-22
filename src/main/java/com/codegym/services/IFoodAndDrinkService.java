package com.codegym.services;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IFoodAndDrinkService {

    //LamNT create foodAndDrink
    void createFoodAndDrink(FoodAndDrink foodAndDrink);

    //LamNT update foodAndDrink
    void updateFoodAndDrink(FoodAndDrink foodAndDrink);


    //HaNTT: get top 5 new food
    List<FoodAndDrink> topFiveNewProduct();

    //HaNTT: get top 5 popular food
    List<FoodAndDrink> topFivePopularProduct();

    //LinhDN view all food
    Page<FoodAndDrink> viewAllFoodAndDrink(Pageable pageable, String code, String name, Double price, Integer id);

    //LinhDN view all food not Id
    Page<FoodAndDrink> viewAllFoodAndDrinkNoId(Pageable pageable, String code, String name, Double price);

    //LinhDN xem 1 food
    FoodAndDrink viewDetailFoodAndDrink(Integer id);

    //LinhDN xoa 1 food
    void deleteDetailFoodAndDrink(Integer id);

    //BaoHG
    List<FoodAndDrink> findFoodCategoryId(int id);

    //BaoHG
    List<FoodAndDrink> listAll();

    //BaoHG
    Optional<FoodAndDrink> findFoodById(int id);
}
