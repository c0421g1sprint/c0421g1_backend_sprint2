package com.codegym.controller;

import com.codegym.controllers.FoodAndDrinkController;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class FoodAndDrinkResControllergetAllFood {
    @Autowired
    private FoodAndDrinkController foodAndDrinkController;

    @Test
    public void getAll_6() {
        ResponseEntity<List<FoodAndDrink>> list = this.foodAndDrinkController.findFoodCategoryId(1);
        Assertions.assertEquals(HttpStatus.OK, list.getStatusCode());
    }
}
