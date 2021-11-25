package com.codegym.controllers;

import com.codegym.dto.FoodAndDrinkDto;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.codegym.services.IFoodAndDrinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/food-and-drink")
public class FoodAndDrinkController {


    @Autowired //BaoHG
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


    //HaNTT: get top 5 new food
    @GetMapping("/find-top-five-new")
    public ResponseEntity<List<FoodAndDrink>> getTopFiveNew() {
        List<FoodAndDrink> foodAndDrinkList;
        foodAndDrinkList = foodAndDrinkService.topFiveNewProduct();
        if (foodAndDrinkList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foodAndDrinkList, HttpStatus.OK);
    }

    //HaNTT: get top 5 popular food
    @GetMapping("/find-top-five-popular")
    public ResponseEntity<List<FoodAndDrink>> getTopFivePopular() {
        List<FoodAndDrink> foodAndDrinkList;
        foodAndDrinkList = foodAndDrinkService.topFivePopularProduct();
        if (foodAndDrinkList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foodAndDrinkList, HttpStatus.OK);
    }

    //LinhDN: view all food
    @GetMapping("/list")
    public ResponseEntity<Page<FoodAndDrink>> viewAllFad(@PageableDefault(value = 2, sort = "fad_id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(value = "name", required = false) String name,
                                                         @RequestParam(value = "code", required = false) String code,
                                                         @RequestParam(value = "price", required = false) Double price,
                                                         @RequestParam(value = "id", required = false) Integer id) {
        Page<FoodAndDrink> foodAndDrinkList = foodAndDrinkService.viewAllFoodAndDrink(pageable, code, name, price, id);
        if (!foodAndDrinkList.isEmpty()) {
            return new ResponseEntity<>(foodAndDrinkList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //LinhDN xem chi tiet 1 food
    @GetMapping("/detail/{id}")
    public ResponseEntity<FoodAndDrink> viewDetailFad(@PathVariable("id") Integer id) {
        FoodAndDrink foodAndDrink = foodAndDrinkService.viewDetailFoodAndDrink(id);
        if (foodAndDrink != null) {
            return new ResponseEntity<>(foodAndDrink, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //LinhDN xoa 1 food
    @PatchMapping("/delete/{id}")
    public void deleteFad(@PathVariable("id") Integer id) {
        FoodAndDrink foodAndDrink = foodAndDrinkService.viewDetailFoodAndDrink(id);
        if (foodAndDrink != null) {
            foodAndDrinkService.deleteDetailFoodAndDrink(id);
        }
    }

    //LinhDN: view all food No Id
    @GetMapping("/listNoId")
    public ResponseEntity<Page<FoodAndDrink>> viewAllFadNoId(@PageableDefault(value = 2, sort = "fad_id", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(value = "name", required = false) String name,
                                                             @RequestParam(value = "code", required = false) String code,
                                                             @RequestParam(value = "price", required = false) Double price) {
        Page<FoodAndDrink> foodAndDrinkList = foodAndDrinkService.viewAllFoodAndDrinkNoId(pageable, code, name, price);
        if (!foodAndDrinkList.isEmpty()) {
            return new ResponseEntity<>(foodAndDrinkList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //BaoHG
    @GetMapping("/{id}") // loc theo category cua food
    public ResponseEntity<List<FoodAndDrink>> findFoodCategoryId(@PathVariable int id) {
        List<FoodAndDrink> list = this.foodAndDrinkService.findFoodCategoryId(id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //BaoHG
    @GetMapping("/allFood") // lay all food
    public ResponseEntity<List<FoodAndDrink>> listAllFood() {
        List<FoodAndDrink> list = this.foodAndDrinkService.listAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    //BaoHG
    @GetMapping("/food/{id}") // tim theo id food
    public ResponseEntity<Optional<FoodAndDrink>> findFoodAndDrinkById(@PathVariable int id) {
        Optional<FoodAndDrink> foodAndDrink = this.foodAndDrinkService.findFoodById(id);

        if (foodAndDrink.isPresent()) {

            return new ResponseEntity<>(foodAndDrink, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/food") //  //BaoHG tim theo id food
    public ResponseEntity<List<FoodAndDrink>> searchFood(@RequestParam(value = "search") String search) {
        List<FoodAndDrink> foodAndDrink = this.foodAndDrinkService.searchFoodAndDrink(search);
        if (foodAndDrink.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foodAndDrink, HttpStatus.OK);
        }
    }

}
