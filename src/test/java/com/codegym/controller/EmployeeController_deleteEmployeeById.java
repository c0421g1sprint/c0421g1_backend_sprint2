package com.codegym.controller;

import com.codegym.controllers.EmployeeController;
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
public class EmployeeController_deleteEmployeeById {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeController employeeController;

    @Test
    public void deleteEmployee_19 () throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/employee/delete/{id}", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteEmployee_20() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/employee/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteEmployee_21() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/employee/delete/{id}", "a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteEmployee_24() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/employee/delete/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
