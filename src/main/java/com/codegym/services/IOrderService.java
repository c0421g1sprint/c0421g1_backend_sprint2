package com.codegym.services;


import com.codegym.entity.order.Orders;


import java.util.List;
import java.util.Optional;


public interface IOrderService {
    List<Orders> listOrder();

    void saveOrderTable(Orders orders);

    Optional<Orders> listNewOrder();

}
