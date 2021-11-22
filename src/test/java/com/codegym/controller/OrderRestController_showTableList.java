package com.codegym.controller;


import com.codegym.controllers.OrderController;
import com.codegym.entity.table.Tables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class OrderRestController_showTableList {

    @Autowired
    private OrderController orderController;

    // Test list = 0
    @Test
    public void findAllTables_05() {
        ResponseEntity<Page<Tables>> pageResponseEntity = this.orderController.showTableOnService(PageRequest.of(0,6));

        Assertions.assertEquals(HttpStatus.NO_CONTENT, pageResponseEntity.getStatusCode());
    }

    // Test list > 0
    @Test
    public void findAllTables_06() {
        ResponseEntity<Page<Tables>> pageResponseEntity = this.orderController.showTableOnService(PageRequest.of(0,6));

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Tables> tablesPage = pageResponseEntity.getBody();

        Assertions.assertEquals(20, tablesPage.getTotalElements());
        Assertions.assertEquals(4, tablesPage.getTotalPages());
        Assertions.assertEquals("TB-0001", tablesPage.getContent().get(1).getTableCode());
    }
}
