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
public class EmployeeController_findById {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void findEmployeeById_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findEmployeeById_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findEmployeeById_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/{id}", "22"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void findEmployeeById_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
