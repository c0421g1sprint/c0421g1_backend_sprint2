package com.codegym.controller;

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
public class OrderRestController_showTableDetailServiceById {

    @Autowired
    private MockMvc mockMvc;

    // Test null
    @Test
    public void showTableDetailServiceById_01() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/order/on-service/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test rỗng
    @Test
    public void showTableDetailServiceById_02() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/order/on-service/{id}", " "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test id không tồn tại trong DB
    @Test
    public void showTableDetailServiceById_03() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/order/on-service/{id}", 30))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // Test id tồn tại trong DB
    @Test
    public void showTableDetailServiceById_04() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/order/on-service/{id}", 6))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
