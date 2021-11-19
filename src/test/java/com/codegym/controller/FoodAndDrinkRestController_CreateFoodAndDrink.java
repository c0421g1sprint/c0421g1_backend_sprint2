package com.codegym.controller;

import com.codegym.dto.CategoryDto;
import com.codegym.dto.FoodAndDrinkDto;
import com.codegym.entity.food_and_drink.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FoodAndDrinkRestController_CreateFoodAndDrink {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createFoodAndDrink_name_1() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(5000.0);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    @Test
//    public void createFoodAndDrink_name_2() throws Exception {
//        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
//        foodAndDrinkDto.setFadName("Ca");
//        foodAndDrinkDto.setCategory(foodAndDrinkDto.getCategory());
//        foodAndDrinkDto.setFadCode("CFS123");
//        foodAndDrinkDto.setFadPrice(5000);
//        foodAndDrinkDto.setFadImage("tra.jpg");
//    }

//    @Test
//    public void createFoodAndDrink_name_3() throws Exception {
//        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
//        foodAndDrinkDto.setFadName("Cà phê sữa");
//        foodAndDrinkDto.setCategory(foodAndDrinkDto.getCategory());
//        foodAndDrinkDto.setFadCode("CFS123");
//        foodAndDrinkDto.setFadPrice(5000);
//        foodAndDrinkDto.setFadImage("tra.jpg");
//    }
}
