package com.codegym.controllers;

import com.codegym.dto.CategoryDto;
import com.codegym.dto.FoodAndDrinkDto;
import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.codegym.repositories.IFoodAndDrinkRepository;
import com.codegym.services.IFoodAndDrinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/food-and-drink")
public class FoodAndDrinkController {

    @Autowired
    private IFoodAndDrinkService foodAndDrinkService;

    //LamNT create FoodAndDrink
    @PostMapping("/create")
    public ResponseEntity<?> createFoodAndDrink(@RequestBody @Validated FoodAndDrinkDto foodAndDrinkDto) {
        FoodAndDrink foodAndDrink = new FoodAndDrink();
        BeanUtils.copyProperties(foodAndDrinkDto, foodAndDrink);
        foodAndDrinkService.createFoodAndDrink(foodAndDrink);
        return new ResponseEntity<>(foodAndDrink, HttpStatus.CREATED);
    }

    //LamNT update FoodAndDrink
    @PatchMapping("/update")
    public ResponseEntity<?> updateFoodAndDrink(@RequestBody @Validated FoodAndDrinkDto foodAndDrinkDto) {
        FoodAndDrink foodAndDrink = new FoodAndDrink();
        BeanUtils.copyProperties(foodAndDrinkDto, foodAndDrink);
        foodAndDrinkService.updateFoodAndDrink(foodAndDrink);
        return new ResponseEntity<>(foodAndDrink, HttpStatus.OK);
    }
}
