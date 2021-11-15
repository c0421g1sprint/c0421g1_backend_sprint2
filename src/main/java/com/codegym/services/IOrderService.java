package com.codegym.services;

import com.codegym.entity.order.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    Page<Orders> findAllAdv(Pageable pageable, String date, String code);
}
