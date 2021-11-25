package com.codegym.controllers;

import com.codegym.entity.order.OrderDetail;
import com.codegym.entity.order.Orders;
import com.codegym.entity.table.Tables;
import com.codegym.services.IOrderDetailService;
import com.codegym.services.IOrderService;
import com.codegym.services.ITableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PatchMapping("/call-food/{id}")  //BaoHG
    public void callFoodById(@PathVariable int id) {
        this.iTableService.callFoodAndDrink(id);
    }

    @PatchMapping("/call-employee/{id}") //BaoHG
    public void callEmployeeById(@PathVariable int id) {
        this.iTableService.callEmp(id);
    }

    @PatchMapping("/call-pay/{id}") //BaoHG
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

    @PostMapping("/create/orderTable") //  //BaoHG  tao moi 1 thang order all null chi co value table
    public ResponseEntity<Orders> newOrderTable(@RequestBody Orders orders) {
        this.iOrderService.saveOrderTable(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/create/orderDetail")  //BaoHG
    public ResponseEntity<OrderDetail> newOrderDetail(@RequestBody OrderDetail orderDetail) {
        this.iOrderDetailService.saveOrderTail(orderDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @DeleteMapping("/delete/orderDetail/{id}") // xoa 1 mon trong orderDetail
//    public ResponseEntity<Orders> newOrderDetail(@PathVariable int id) {
//        this.iOrderService.deleteOrderDetailByFoodId(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/list/orderNew") //  BaoHG lay ra thang order moi nhat
    public ResponseEntity<Optional<Orders>> getNewOrderDB() {
        Optional<Orders> list = this.iOrderService.listNewOrder();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/list/order") //  BaoHG lay ra all order
    public ResponseEntity<List<Orders>> findAllOrder() {
        List<Orders> list = this.iOrderService.listOrder();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/list/orderDetail") //  BaoHG lay ra all order detail
    public ResponseEntity<List<OrderDetail>> findAllOrderDetail() {
        List<OrderDetail> list = this.iOrderDetailService.listOrderDetail();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("orderDetail/{id}")  //BaoHG
    public ResponseEntity<List<OrderDetail>> findByIdOrderDetail(@PathVariable int id) {
        List<OrderDetail> list = this.iOrderDetailService.findByOrderId(id);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("delete/orderDetail/{id}") //  //BaoHG xoa 1 mon trong orderDetail
    public ResponseEntity<OrderDetail> newOrderDetail(@PathVariable int id) {
        List<OrderDetail> orderDetail = this.iOrderDetailService.findByOrderId(id);
        if (orderDetail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            this.iOrderDetailService.deleteOrderDetailByFadId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
}
