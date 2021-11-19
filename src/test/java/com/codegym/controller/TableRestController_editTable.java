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
public class TableRestController_editTable {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void editStudent_name_19() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode(null);
        tablesDto.setLocation("Tang-1");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("Tày");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);
        tablesDto.setTableId(2);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/table/update")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_address_20() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("");
        tablesDto.setLocation("tang-1");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("Tày");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);
        tablesDto.setTableId(2);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/table/update")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_address_21() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("MB-1235");
        tablesDto.setLocation("tang1");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("Tày");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);
        tablesDto.setTableId(2);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/table/update")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_address_22() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("qwe");
        tablesDto.setLocation("Huế");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("Tày");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);
        tablesDto.setTableId(2);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/table/update")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_address_23() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("123e");
        tablesDto.setLocation("Huế");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("Tày");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);
        tablesDto.setTableId(2);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/table/update")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void editStudent_name_24() throws Exception {
        TablesDto tablesDto = new TablesDto();
        tablesDto.setTableCode("MB-0121");
        tablesDto.setLocation("Huế");
        tablesDto.setMaximumCapacity("10");
        tablesDto.setTableStatus("Tày");
        tablesDto.setAvailableFlag(false);
        tablesDto.setDeleteFlag(false);
        tablesDto.setTableId(2);
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/api/table/update")
                .content(this.objectMapper.writeValueAsString(tablesDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
