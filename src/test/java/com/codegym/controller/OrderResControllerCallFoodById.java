package com.codegym.controller;

import com.codegym.controllers.OrderController;
import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.codegym.entity.table.Tables;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.Table;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderResControllerCallFoodById {
    @Autowired
    private OrderController orderController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void callFood_dung() throws Exception {
        Tables tables = new Tables();
//        tables.setOnService(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/order/call-food/1")
                .content(this.objectMapper.writeValueAsString(tables))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void callFood_loi_sai_duong_dan() throws Exception {
        Tables tables = new Tables();
//        tables.setOnService(1);

        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/order/call-food/")
                .content(this.objectMapper.writeValueAsString(tables))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
