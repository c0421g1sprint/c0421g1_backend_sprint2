package com.codegym.controllers;

import com.codegym.entity.order.Orders;
import com.codegym.repositories.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private IOrdersRepository ordersRepository;

    @GetMapping
    public ResponseEntity<?> showList(@PageableDefault(value = 5) Pageable pageable,
            @RequestParam(required = false) String tableCode,
                                      @RequestParam(required = false) String date){
        Page<Orders> ordersList = this.ordersRepository.findAllAdv(pageable,tableCode, date) ;
        if (!ordersList.getContent().isEmpty()){
            return new ResponseEntity<>(ordersList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
