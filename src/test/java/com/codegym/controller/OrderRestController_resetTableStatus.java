package com.codegym.controller;

import com.codegym.controllers.OrderController;
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
public class OrderRestController_resetTableStatus {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderController orderController;

    @Test
    public void resetTableStatusById_19() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/order/on-service/reset/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void resetTableStatusById_20() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/order/on-service/reset/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void resetTableStatusById_21() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/order/on-service/reset/{id}", "xyz"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void resetTableStatusById_24() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/order/on-service/reset/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
