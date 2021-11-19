package com.codegym.controller.category;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryController_FindById {
    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void findById_1() throws Exception {
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get(
//                        "/api/category/detail/{id}", null))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }

    @Test
    public void findById_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/category/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/category/detail/{id}", "6"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void findById_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/category/detail/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.categoryName").value("Cà phê"))
                .andExpect(jsonPath("$.categoryCode").value("CAFE"))
                .andExpect(jsonPath("$.deleteFlag").value(false));
    }
}
