package com.codegym.services.impls;

import com.codegym.entity.order.OrderDetail;
import com.codegym.repositories.IOrderDetailRepository;
import com.codegym.services.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository iOrderDetailRepository; //BaoHG

    @Override // BaoHG
    public List<OrderDetail> listOrderDetail() {
        return this.iOrderDetailRepository.findAll();

    }

    @Override // BaoHG
    public void saveOrderTail(OrderDetail orderDetail) {
        this.iOrderDetailRepository.createOrderDetail(orderDetail.getFad().getFadId(), orderDetail.getOrders().getOrderId(), orderDetail.getQuantity());
    }

    @Override //BaoHG
    public List<OrderDetail> findByOrderId(int id) {
        return this.iOrderDetailRepository.findOrderDetailById(id);
    }

//    @Override
//    public void deleteOrderDetailByFadId(int id ) {
//        this.iOrderDetailRepository.deleteById(id);
//    }

    @Override //BaoHG
    public void deleteOrderDetailByFadId(int id) {
        this.iOrderDetailRepository.deleteOrderDetail(id);
    }


}
