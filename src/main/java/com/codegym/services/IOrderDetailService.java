package com.codegym.services;

import com.codegym.entity.order.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailService {
    List<OrderDetail> listOrderDetail(); //BaoHG

    void saveOrderTail(OrderDetail orderDetail);//BaoHG

    List<OrderDetail> findByOrderId(int id);//BaoHG

    void deleteOrderDetailByFadId(int id);//BaoHG
}
