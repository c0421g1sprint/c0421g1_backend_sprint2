package com.codegym.controller.category;

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
public class CategoryDelelte {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void deleteById_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/category/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteById_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/category/delete/{id}", "6"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void deleteById_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(
                        "/api/category/delete/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
