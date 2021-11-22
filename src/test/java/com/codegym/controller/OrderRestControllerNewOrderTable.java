package com.codegym.controller;

import com.codegym.entity.order.Orders;
import com.codegym.entity.table.Tables;
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
public class OrderRestControllerNewOrderTable {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void newOrder_dung() throws Exception {
        Orders orders = new Orders();

        Tables tables = new Tables();

        tables.setTableId(1);
//        tables.setTableCode("TB-0001");
//        tables.setAvailableFlag(false);
//        tables.setTableStatus("Trống");
//        tables.setDeleteFlag(false);
//        tables.setLocation("Tầng 1");
//        tables.setMaximumCapacity("5");
//        tables.setOnService(1);

        orders.setTables(tables);


        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/order/create/orderTable")
                .content(this.objectMapper.writeValueAsString(tables))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
