package com.codegym.services.impls;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.codegym.repositories.IFoodAndDrinkRepository;
import com.codegym.services.IFoodAndDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodAndDrinkServiceImpl implements IFoodAndDrinkService {

    @Autowired
    IFoodAndDrinkRepository foodAndDrinkRepository;

    //LamNT create fad
    @Override
    public void createFoodAndDrink(FoodAndDrink foodAndDrink) {
        foodAndDrinkRepository.createFoodAndDrink(foodAndDrink.getFadCode(), foodAndDrink.getFadImage(),
                foodAndDrink.getFadName(), foodAndDrink.getFadPrice(), foodAndDrink.getCategory().getCategoryId());
    }

    //LamNT update fad
    @Override
    public void updateFoodAndDrink(FoodAndDrink foodAndDrink) {
        foodAndDrinkRepository.updateFoodAndDrink(foodAndDrink.getFadCode(), foodAndDrink.getFadImage(), foodAndDrink.getFadName(),
                foodAndDrink.getFadPrice(), foodAndDrink.getCategory().getCategoryId(), foodAndDrink.getFadId());
    }


    //HaNTT: get top 5 new food
    @Override
    public List<FoodAndDrink> topFiveNewProduct() {
        return foodAndDrinkRepository.topFiveNewProduct();
    }
    //HaNTT: get top 5 popular food
    @Override
    public List<FoodAndDrink> topFivePopularProduct() {
        return foodAndDrinkRepository.topFivePopularProduct();
    }

    @Override
    public Page<FoodAndDrink> viewAllFoodAndDrink(Pageable pageable, String code, String name, Double price, Integer id) {
        return foodAndDrinkRepository.viewAllFoodAndDrink(pageable, code, name, price, id);
    }

    @Override
    public Page<FoodAndDrink> viewAllFoodAndDrinkNoId(Pageable pageable, String code, String name, Double price) {
        return foodAndDrinkRepository.viewAllFoodAndDrinkNoId(pageable,code,name,price);
    }

    @Override
    public FoodAndDrink viewDetailFoodAndDrink(Integer id) {
        return foodAndDrinkRepository.viewDetailFad(id);
    }

    @Override
    public void deleteDetailFoodAndDrink(Integer id) {
        foodAndDrinkRepository.deleteFad(id);
    }
}
