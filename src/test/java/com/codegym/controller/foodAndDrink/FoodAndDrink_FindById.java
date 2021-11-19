package com.codegym.controller.foodAndDrink;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FoodAndDrink_FindById {
    @Autowired
    private MockMvc mockMvc;

    //Test tim kiem doi tuong rong
    @Test
    public void findById_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/food-and-drink/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Test tim kiem doi tuong khong co trong DB
    @Test
    public void findById_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/food-and-drink/detail/{id}", "50"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //Test tim kiem doi tuong co trong DB
    @Test
    public void findById_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/food-and-drink/detail/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.fadName").value("Bạc xỉu"))
                .andExpect(jsonPath("$.fadCode").value("FAD-0001"))
                .andExpect(jsonPath("$.fadPrice").value(25000))
                .andExpect(jsonPath("$.fadWaitTime").value(3))
                .andExpect(jsonPath("$.fadImage").value("https://www.thecupscoffee.vn/upload/1609309504-menu.png"))
                .andExpect(jsonPath("$.category.categoryId").value(1))
                .andExpect(jsonPath("$.deleteFlag").value(false));
    }
}
