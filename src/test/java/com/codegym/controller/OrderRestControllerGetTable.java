package com.codegym.controller;

import com.codegym.controllers.OrderController;
import com.codegym.entity.table.Tables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootTest
public class OrderRestControllerGetTable {
    @Autowired
    private OrderController orderController;

    @Test
    public void getRanDomTable() {
        ResponseEntity<Optional<Tables>> getTable = this.orderController.getTable();
        Assertions.assertEquals(HttpStatus.OK, getTable.getStatusCode());
    }


}
