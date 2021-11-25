package com.codegym.services;

import com.codegym.entity.order.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface IOrderDetailService {
    List<OrderDetail> listOrderDetail();

    void saveOrderTail(OrderDetail orderDetail);

    List<OrderDetail> findByOrderId(int id);

    void deleteOrderDetailByFadId(int id);
}
