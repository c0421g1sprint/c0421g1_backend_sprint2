package com.codegym.controller;

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
public class AccountRestController_getInforAccount {
    @Autowired
    private MockMvc mockMvc;
    @Test

    public void showUserDetail_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/employee/userDetail", (Object) null))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void showUserDetail_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/employee/userDetail", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void showUserDetail_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/employee/userDetail", "1233"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void showUserDetail_4() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/employee/userDetail?name=nhat123"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.employeeId").value(1))
                .andExpect(jsonPath("$.account.accountId").value(1))
                .andExpect(jsonPath("$.account.accountPassword").value("hello123"))
                .andExpect(jsonPath("$.account.accountUsername").value("nhat123"))
                .andExpect(jsonPath("$.employeeGender").value(1))
                .andExpect(jsonPath("$.employeeAddress").value("da nang"))
                .andExpect(jsonPath("$.employeeBirthday").value("2000-02-02"))
                .andExpect(jsonPath("$.employeeSalary").value(15))
                .andExpect(jsonPath("$.level.levelId").value(1))
                .andExpect(jsonPath("$.employeeImage").value("aaa"))
                .andExpect(jsonPath("$.employeePhone").value("0987786688"))
                .andExpect(jsonPath("$.deleteFlag").value(false))
                .andExpect(jsonPath("$.account.email").value("nhat@gmail.com"));
    }


}
