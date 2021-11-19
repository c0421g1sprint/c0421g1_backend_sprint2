package com.codegym.controller;

import com.codegym.controllers.CategoryController;
import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.codegym.services.ICategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class CategoryRestController_listAllCategory {
    @Autowired
    private CategoryController categoryController;

    @Test // test lay ra all category
    public void getAllCatetory() {
        ResponseEntity<List<Category>> category = this.categoryController.findAllName();
        Assertions.assertEquals(HttpStatus.OK,category.getStatusCode());
    }
}
