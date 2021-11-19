package com.codegym.controller;

import com.codegym.controllers.OrderController;
import com.codegym.entity.table.Tables;
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
public class OrderResControllerCallEmployee {
    @Autowired
    private OrderController orderController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void callEmp_dung() throws Exception {
        Tables tables = new Tables();


        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/order/call-employee/2")
                .content(this.objectMapper.writeValueAsString(tables))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void callPay_loi_sai_duong_dan() throws Exception {
        Tables tables = new Tables();


        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/order/call-employee/")
                .content(this.objectMapper.writeValueAsString(tables))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
