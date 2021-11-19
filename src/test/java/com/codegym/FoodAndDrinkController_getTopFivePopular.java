package com.codegym;

import com.codegym.controllers.FoodAndDrinkController;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FoodAndDrinkController_getTopFivePopular {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FoodAndDrinkController foodAndDrinkController;

    @Test
    public void getTopFivePopular_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/food-and-drink/find-top-five-popular"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getTopFivePopular_6() {
        ResponseEntity<List<FoodAndDrink>> responseEntity
                = this.foodAndDrinkController.getTopFivePopular();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<FoodAndDrink> foodAndDrinkList = responseEntity.getBody();

        Assertions.assertEquals(5, foodAndDrinkList.size());
        Assertions.assertEquals("FAD-0002", foodAndDrinkList.get(0).getFadCode());
    }
}

