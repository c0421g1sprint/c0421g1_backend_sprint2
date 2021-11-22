package com.codegym.controller;

import com.codegym.dto.EditPasswordAccountDto;
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
public class PasswordRestController_editPassword {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void editPassword_19() throws Exception {
        EditPasswordAccountDto editPasswordAccountDto = new EditPasswordAccountDto();
        editPasswordAccountDto.setAccountPassword(null);
        editPasswordAccountDto.setAccountId(1);
        editPasswordAccountDto.setOldPassword("hello123");
        editPasswordAccountDto.setConfirmPassword(null);


        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/account/editPass")
                .content(this.objectMapper.writeValueAsString(editPasswordAccountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editPassword_20() throws Exception {
        EditPasswordAccountDto editPasswordAccountDto = new EditPasswordAccountDto();
        editPasswordAccountDto.setAccountPassword("");
        editPasswordAccountDto.setAccountId(1);
        editPasswordAccountDto.setOldPassword("hello123");
        editPasswordAccountDto.setConfirmPassword("");


        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/account/editPass")
                .content(this.objectMapper.writeValueAsString(editPasswordAccountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editPassword_21() throws Exception {
        EditPasswordAccountDto editPasswordAccountDto = new EditPasswordAccountDto();
        editPasswordAccountDto.setAccountPassword("hi%#");
        editPasswordAccountDto.setAccountId(1);
        editPasswordAccountDto.setOldPassword("hello123");
        editPasswordAccountDto.setConfirmPassword("hi%#");


        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/account/editPass")
                .content(this.objectMapper.writeValueAsString(editPasswordAccountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editPassword_22() throws Exception {
        EditPasswordAccountDto editPasswordAccountDto = new EditPasswordAccountDto();
        editPasswordAccountDto.setAccountPassword("aassssssssssssssssssssssssssssssssssssssssadsđâsđá");
        editPasswordAccountDto.setAccountId(1);
        editPasswordAccountDto.setOldPassword("hello123");
        editPasswordAccountDto.setConfirmPassword("aassssssssssssssssssssssssssssssssssssssssadsđâsđá");


        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/account/editPass")
                .content(this.objectMapper.writeValueAsString(editPasswordAccountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editPassword_23() throws Exception {
        EditPasswordAccountDto editPasswordAccountDto = new EditPasswordAccountDto();
        editPasswordAccountDto.setAccountPassword("231");
        editPasswordAccountDto.setAccountId(1);
        editPasswordAccountDto.setOldPassword("hello123");
        editPasswordAccountDto.setConfirmPassword("123");


        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/account/editPass")
                .content(this.objectMapper.writeValueAsString(editPasswordAccountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void editPassword_24() throws Exception {
        EditPasswordAccountDto editPasswordAccountDto = new EditPasswordAccountDto();
        editPasswordAccountDto.setAccountPassword("12223238");
        editPasswordAccountDto.setAccountId(6);
        editPasswordAccountDto.setOldPassword("1235558");
        editPasswordAccountDto.setConfirmPassword("12223238");


        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/account/editPass")
                .content(this.objectMapper.writeValueAsString(editPasswordAccountDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
