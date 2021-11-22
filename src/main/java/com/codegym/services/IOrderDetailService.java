package com.codegym.services;

import com.codegym.entity.order.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailService {
    List<OrderDetail> listOrderDetail();

    void saveOrderTail(OrderDetail orderDetail);

    Optional<OrderDetail> findById(int id);
}
