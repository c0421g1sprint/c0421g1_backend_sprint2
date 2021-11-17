package com.codegym.services.impls;

import com.codegym.entity.order.OrderDetail;
import com.codegym.entity.order.Orders;
import com.codegym.repositories.IOrdersRepository;
import com.codegym.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrdersRepository ordersRepository;


    @Override
    public List<Orders> listOrder() {
        return this.ordersRepository.findAll();
    }

    @Override
    public void saveOrderTable(Orders orders) {
        this.ordersRepository.createOrderTable(orders.getTables().getTableId());
    }

    @Override
    public Optional<Orders> listNewOrder() {
       return this.ordersRepository.getNewOrder();
    }


}
