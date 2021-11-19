package com.codegym.controller.foodAndDrink;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FoodAndDrink_Delete {
    @Autowired
    private MockMvc mockMvc;
    //Xoa 1 doi tuong rong
    @Test
    public void deleteById_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/food-and-drink/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Xoa 1 doi tuong khong co trong DB
    @Test
    public void deleteById_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/food-and-drink/delete/{id}", "50"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //Xoa 1 doi tuong  co trong DB
    @Test
    public void deleteById_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/food-and-drink/delete/{id}", "18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
