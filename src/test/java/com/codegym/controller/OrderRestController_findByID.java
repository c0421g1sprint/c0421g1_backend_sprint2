package com.codegym.controller;

import com.codegym.controllers.OrderController;
import com.codegym.entity.order.Orders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderRestController_findByID {
    @Autowired
    private OrderController orderController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getById_2_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/order/find/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getById_2_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/order/find/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_4_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/order/find/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.createDate").value("2021-02-02"))
                .andExpect(jsonPath("$.orderCode").value("HD0001"))
                .andExpect(jsonPath("$.orderId").value(1));
    }

    @Test
    public void getInfoStudent_4_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/order/find/{id}", "4"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.createDate").value("2021-02-03"))
                .andExpect(jsonPath("$.orderCode").value("HD0004"))
                .andExpect(jsonPath("$.orderId").value(4));
    }
}
