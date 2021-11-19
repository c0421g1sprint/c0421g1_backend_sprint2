package com.codegym.controller;

import com.codegym.controllers.OrderController;
import com.codegym.entity.order.Orders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class OrderRestController_getOrderList {
    @Autowired
    private OrderController orderController;

    @Test
    public void showListOrder_5() {
        ResponseEntity<Page<Orders>> pageResponseEntity
                = this.orderController.showList(PageRequest.of(0, 5),"","");

        Assertions.assertEquals(HttpStatus.NOT_ACCEPTABLE, pageResponseEntity.getStatusCode());
    }

    @Test
    public void showListOrder_6_1() {
        ResponseEntity<Page<Orders>> pageResponseEntity
                = this.orderController.showList(PageRequest.of(0, 5),"null","null");

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Orders> ordersPage = pageResponseEntity.getBody();

        Assertions.assertEquals(15, ordersPage.getTotalElements());
        Assertions.assertEquals(3, ordersPage.getTotalPages());
        Assertions.assertEquals("HD0001", ordersPage.getContent().get(0).getOrderCode());
    }

    @Test
    public void showListOrder_6_2() {
        ResponseEntity<Page<Orders>> pageResponseEntity
                = this.orderController.showList(PageRequest.of(0, 5),"HD0001","null");

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Orders> ordersPage = pageResponseEntity.getBody();

        Assertions.assertEquals(1, ordersPage.getTotalElements());
        Assertions.assertEquals(1, ordersPage.getTotalPages());
        Assertions.assertEquals("HD0001", ordersPage.getContent().get(0).getOrderCode());
    }

    @Test
    public void showListOrder_6_3() {
        ResponseEntity<Page<Orders>> pageResponseEntity
                = this.orderController.showList(PageRequest.of(0, 5),"null","2021-02-02");

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Orders> ordersPage = pageResponseEntity.getBody();

        Assertions.assertEquals(2, ordersPage.getTotalElements());
        Assertions.assertEquals(1, ordersPage.getTotalPages());
        Assertions.assertEquals("2021-02-02", ordersPage.getContent().get(0).getCreateDate());
    }

    @Test
    public void showListOrder_6_4() {
        ResponseEntity<Page<Orders>> pageResponseEntity
                = this.orderController.showList(PageRequest.of(0, 5),"hd0001","2021-02-02");

        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Orders> ordersPage = pageResponseEntity.getBody();

        Assertions.assertEquals(1, ordersPage.getTotalElements());
        Assertions.assertEquals(1, ordersPage.getTotalPages());
        Assertions.assertEquals("2021-02-02", ordersPage.getContent().get(0).getCreateDate());
    }
}
