package com.codegym.controller;

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
public class FoodAndDrinkRestController_UpdateFoodAndDrink {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateFoodAndDrink_name_1() throws Exception {
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

    @Test
    public void updateFoodAndDrink_name_2() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà");
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

    @Test
    public void updateFoodAndDrink_name_3() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(5000.0);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateFoodAndDrink_category_4() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(5000.0);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFoodAndDrink_category_5() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(5000.0);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateFoodAndDrink_code_6() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode(null);
        foodAndDrinkDto.setFadPrice(5000.0);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFoodAndDrink_code_7() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(5000.0);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateFoodAndDrink_price_8() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(null);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFoodAndDrink_price_9() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(3000.0);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFoodAndDrink_price_10() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(10000.0);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateFoodAndDrink_price_11() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(10000.0);
        foodAndDrinkDto.setFadImage(null);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFoodAndDrink_price_12() throws Exception {
        FoodAndDrinkDto foodAndDrinkDto = new FoodAndDrinkDto();
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("Cà phê");
        category.setCategoryCode("CAFE");
        foodAndDrinkDto.setFadName("Cà phê sữa");
        foodAndDrinkDto.setCategory(category);
        foodAndDrinkDto.setFadCode("CFS123");
        foodAndDrinkDto.setFadPrice(10000.0);
        foodAndDrinkDto.setFadImage("tra.jpg");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/food-and-drink/create")
                        .content(this.objectMapper.writeValueAsString(foodAndDrinkDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
