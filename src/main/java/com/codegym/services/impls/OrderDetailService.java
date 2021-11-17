package com.codegym.services.impls;

import com.codegym.entity.order.OrderDetail;
import com.codegym.repositories.IOrderDetailRepository;
import com.codegym.services.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;

    @Override
    public List<OrderDetail> listOrderDetail() {
        return this.iOrderDetailRepository.findAll();

    }

    @Override
    public void saveOrderTail(OrderDetail orderDetail) {
        this.iOrderDetailRepository.save(orderDetail);
    }
}
