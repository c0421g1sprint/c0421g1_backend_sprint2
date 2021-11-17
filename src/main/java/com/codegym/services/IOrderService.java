package com.codegym.services;

import com.codegym.entity.order.OrderDetail;
import com.codegym.entity.order.Orders;
import org.hibernate.criterion.Order;

import java.util.List;
import java.util.Optional;


public interface IOrderService {
    List<Orders> listOrder();

    void saveOrderTable(Orders orders);
    Optional<Orders> listNewOrder();
//    void saveOrderTail(OrderDetail orderDetail);


}
