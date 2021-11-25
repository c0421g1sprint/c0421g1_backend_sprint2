package com.codegym.controllers;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.codegym.services.IFoodAndDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/food-and-drink")
public class FoodAndDrinkController {


    @Autowired
    private IFoodAndDrinkService foodAndDrinkService;

    @GetMapping("/{id}") // loc theo category cua food
    public ResponseEntity<List<FoodAndDrink>> findFoodCategoryId(@PathVariable int id) {
        List<FoodAndDrink> list = this.foodAndDrinkService.findFoodCategoryId(id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/allFood") // lay all food
    public ResponseEntity<List<FoodAndDrink>> listAllFood() {
        List<FoodAndDrink> list = this.foodAndDrinkService.listAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }


    @GetMapping("/food/{id}") // tim theo id food
    public ResponseEntity<Optional<FoodAndDrink>> findFoodAndDrinkById(@PathVariable int id) {
        Optional<FoodAndDrink> foodAndDrink = this.foodAndDrinkService.findFoodById(id);

        if (foodAndDrink.isPresent()) {

            return new ResponseEntity<>(foodAndDrink, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/food") // tim theo id food
    public ResponseEntity<List<FoodAndDrink>> searchFood(@RequestParam(value = "search") String search) {
        List<FoodAndDrink> foodAndDrink = this.foodAndDrinkService.searchFoodAndDrink(search);
        if (foodAndDrink.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foodAndDrink, HttpStatus.OK);
        }
    }

}
