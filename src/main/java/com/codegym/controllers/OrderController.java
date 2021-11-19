package com.codegym.controllers;

import com.codegym.entity.order.Orders;
import com.codegym.entity.table.Tables;
import com.codegym.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/order")
public class OrderController {

    // TaiHVK inject interfaces IOrderService 17/11/2021
    @Autowired
    private IOrderService iOrderService;


    // TaiHVK coding show all available tables by list method 17/11/2021
    @GetMapping(value = "/on-service")
    public ResponseEntity<Page<Tables>> showTableOnService(@PageableDefault(size = 6) Pageable pageable) {
        Page<Tables> tablesPage = this.iOrderService.showTableList(pageable);

        if (tablesPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tablesPage, HttpStatus.OK);
    }


    // TaiHVK coding change table on service status method 17/11/2021
    @PatchMapping(value = "/on-service/handle/{id}")
    public ResponseEntity<Void> changeTableOnServiceStatus(@PathVariable int id) {
        this.iOrderService.changeTableOnServiceStatus(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    // TaiHVK coding reset table status method 17/11/2021
    @PatchMapping(value = "/on-service/reset/{id}")
    public ResponseEntity<Void> changeTableStatus(@PathVariable int id) {
        this.iOrderService.resetTableStatus(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    // TaiHVK coding show table order detail method 17/11/2021
    @GetMapping(value = "/on-service/{id}")
    public ResponseEntity<Orders> showOrderDetail(@PathVariable(value = "id") Integer id) {
        Orders orders = this.iOrderService.showOrderDetail(id);

        if (orders == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
