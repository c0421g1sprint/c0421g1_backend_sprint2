package com.codegym.services;

import com.codegym.entity.order.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetail> listOrderDetail();

    void saveOrderTail(OrderDetail orderDetail);
}
