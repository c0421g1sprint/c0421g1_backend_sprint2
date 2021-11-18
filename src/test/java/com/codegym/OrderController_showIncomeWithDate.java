package com.codegym;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderController_showIncomeWithDate {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void showIncomeWithDate_2_1() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/order/income-date?startDate=" + "&endDate="))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void showIncomeWithDate_2_2() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/order/income-date?startDate=2021-11-01" + "&endDate="))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void showIncomeWithDate_2_3() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/order/income-date?startDate=" + "&endDate=2021-11-18"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    @Test
    public void showIncomeWithDate_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/order/income-date?startDate=" + "2021-11-01" + "&endDate=" + "2021-11-18"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.incomeWithDate").value("675000"));
    }
}
