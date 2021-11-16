package com.codegym.controllers;

import com.codegym.entity.order.Orders;
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
    @Autowired
    private IOrderService orderService;

    //DanhNT: Danh sách hoá đơn phân trang
    @GetMapping("/list/{orderCode}/{date}")
    public ResponseEntity<Page<Orders>> showList(@PageableDefault(value = 5) Pageable pageable,
            @PathVariable(required = false) String orderCode,
                                      @PathVariable(required = false) String date){
        if (orderCode.equals("null")){
            orderCode = null;
        }
        if (date.equals("null")){
            date = null;
        }
        Page<Orders> ordersList = this.orderService.findAllAdv(pageable, date, orderCode);
        if (!ordersList.getContent().isEmpty()){
            return new ResponseEntity<>(ordersList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
