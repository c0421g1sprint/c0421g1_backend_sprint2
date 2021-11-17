package com.codegym.controllers;

import com.codegym.entity.order.OrderDetail;
import com.codegym.entity.order.Orders;
import com.codegym.entity.table.Tables;
import com.codegym.services.IOrderDetailService;
import com.codegym.services.IOrderService;
import com.codegym.services.ITableService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private ITableService iTableService;

    @Autowired
    private IOrderDetailService iOrderDetailService;

    @PatchMapping("/call-food/{id}")
    public void callFoodById(@PathVariable int id) {
        this.iTableService.callFoodAndDrink(id);
    }

    @PatchMapping("/call-employee/{id}")
    public void callEmployeeById(@PathVariable int id) {
        this.iTableService.callEmp(id);
    }

    @PatchMapping("/call-pay/{id}")
    public void callPayById(@PathVariable int id) {
        this.iTableService.pay(id);
    }

    @GetMapping("/table") // ley ra 1 cai ban bat ki neu no con trong
    public ResponseEntity<Optional<Tables>> getTable() {
        Optional<Tables> tables = this.iTableService.tableRandom();
        if (tables.isPresent()) {
            return new ResponseEntity<>(tables, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/create/orderTable") // tao moi 1 thang order all null chi co value table
    public ResponseEntity<Order> newOrderTable(@RequestBody Orders orders) {
        this.iOrderService.saveOrderTable(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/create/orderDetail")
    public ResponseEntity<OrderDetail> newOrderDetail(@RequestBody OrderDetail orderDetail) {
        this.iOrderDetailService.saveOrderTail(orderDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list/orderNew") // lay ra thang order moi nhat
    public ResponseEntity<Optional<Orders>> getNewOrderDB() {
        Optional<Orders>list = this.iOrderService.listNewOrder();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/list/order") // lay ra all order
    public ResponseEntity<List<Orders>> findAllOrder() {
        List<Orders> list = this.iOrderService.listOrder();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/list/orderDetail") // lay ra all order detail
    public ResponseEntity<List<OrderDetail>> findAllOrderDetail() {
        List<OrderDetail> list = this.iOrderDetailService.listOrderDetail();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



}
