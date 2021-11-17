package com.codegym.services.impls;

import com.codegym.entity.order.Orders;
import com.codegym.repositories.IOrdersRepository;
import com.codegym.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrdersRepository ordersRepository;





































    //DanhNT: Danh sách hoá đơn phân trang
    @Override
    public Page<Orders> findAllAdv(Pageable pageable, String date, String code) {
        return this.ordersRepository.findAllAdv(pageable, date, code);
    }
}
