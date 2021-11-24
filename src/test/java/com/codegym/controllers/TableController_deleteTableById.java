package com.codegym.controllers;

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
class TableController_deleteTableById {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deleteTableById_26() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/table/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    void deleteTableById_28() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/table/delete/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
