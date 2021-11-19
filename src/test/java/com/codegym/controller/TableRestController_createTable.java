package com.codegym.controller;
import com.codegym.dto.TablesDto;
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
public class TableRestController_createTable {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    public void createStudent_name_13() throws Exception {
//        TablesDto tablesDto = new TablesDto();
//        tablesDto.setTableCode(null);
//        tablesDto.setLocation("Tang-1");
//        tablesDto.setMaximumCapacity("10");
//        tablesDto.setTableStatus("trong");
//        tablesDto.setAvailableFlag(false);
//        tablesDto.setDeleteFlag(false);
//
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/table/add")
//                .content(this.objectMapper.writeValueAsString(tablesDto))
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }

    @Test
    public void createStudent_address_14() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("");
        tablesDto.setLocation("Tang-1");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("trong");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/table/add")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createStudent_name_15() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("MB-112");
        tablesDto.setLocation("Tang-1");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("trong");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/table/add")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createStudent_name_16() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("MB-112");
        tablesDto.setLocation("Tang-1");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("trong");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/table/add")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStudent_name_17() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("MB-112");
        tablesDto.setLocation("Tang-1");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("trong");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/table/add")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createStudent_18() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("MB-7777");
        tablesDto.setLocation("Tang-1");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("trong");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/table/add")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

