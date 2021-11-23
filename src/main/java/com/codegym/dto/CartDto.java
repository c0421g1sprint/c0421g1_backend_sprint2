package com.codegym.dto;


import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<FoodAndDrinkDto,Integer>foodAndDrinkIntegerMap = new HashMap<>();

    public CartDto(){

    }

    public Map<FoodAndDrinkDto, Integer> getFoodAndDrinkIntegerMap() {
        return foodAndDrinkIntegerMap;
    }

    public void setFoodAndDrinkIntegerMap(Map<FoodAndDrinkDto, Integer> foodAndDrinkIntegerMap) {
        this.foodAndDrinkIntegerMap = foodAndDrinkIntegerMap;
    }

    public void addFoodAndDrink(FoodAndDrinkDto foodAndDrinkDto){
        if (this.foodAndDrinkIntegerMap.containsKey(foodAndDrinkDto)){
            Integer value = this.foodAndDrinkIntegerMap.get(foodAndDrinkDto);
            this.foodAndDrinkIntegerMap.put(foodAndDrinkDto,value + 1);
        }else {
            this.foodAndDrinkIntegerMap.put(foodAndDrinkDto,1);
        }
    }

}
