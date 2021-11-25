package com.codegym.services;


import com.codegym.entity.order.Orders;


import java.util.List;
import java.util.Optional;


public interface IOrderService {
    List<Orders> listOrder(); //BaoHG

    void saveOrderTable(Orders orders);//BaoHG

    Optional<Orders> listNewOrder();//BaoHG

}
