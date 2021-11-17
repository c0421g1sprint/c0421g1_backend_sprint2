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

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/food-and-drink")
public class FoodAndDrinkController {

    @Autowired
    private IFoodAndDrinkService foodAndDrinkService;

    //LamNT create category
    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody @Validated CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        foodAndDrinkService.saveCategory(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    //LamNT update category
    @PatchMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody @Validated CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        foodAndDrinkService.updateCategory(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    //LamNT create FoodAndDrink
    @PostMapping("/create-fad")
    public ResponseEntity<?> createFoodAndDrink(@RequestBody @Validated FoodAndDrinkDto foodAndDrinkDto) {
        FoodAndDrink foodAndDrink = new FoodAndDrink();
        BeanUtils.copyProperties(foodAndDrinkDto, foodAndDrink);
        foodAndDrinkService.createFoodAndDrink(foodAndDrink);
        return new ResponseEntity<>(foodAndDrink, HttpStatus.CREATED);
    }

    //LamNT update FoodAndDrink
    @PatchMapping("/update-fad")
    public ResponseEntity<?> updateFoodAndDrink(@RequestBody @Validated FoodAndDrinkDto foodAndDrinkDto) {
        FoodAndDrink foodAndDrink = new FoodAndDrink();
        BeanUtils.copyProperties(foodAndDrinkDto, foodAndDrink);
        foodAndDrinkService.updateFoodAndDrink(foodAndDrink);
        return new ResponseEntity<>(foodAndDrink, HttpStatus.OK);
    }

    //HaNTT: get top 5 new food
    @GetMapping("/find-top-five-new")
    public ResponseEntity<List<FoodAndDrink>> getTopFiveNew() {
        List<FoodAndDrink> foodAndDrinkList;
        foodAndDrinkList = foodAndDrinkService.topFiveNewProduct();
        if (foodAndDrinkList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foodAndDrinkList,HttpStatus.OK);
    }

    //HaNTT: get top 5 popular food
    @GetMapping("/find-top-five-popular")
    public ResponseEntity<List<FoodAndDrink>> getTopFivePopular() {
        List<FoodAndDrink> foodAndDrinkList;
        foodAndDrinkList = foodAndDrinkService.topFivePopularProduct();
        if (foodAndDrinkList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foodAndDrinkList,HttpStatus.OK);
    }
}
