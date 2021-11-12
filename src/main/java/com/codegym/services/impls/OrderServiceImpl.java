package com.codegym.services.impls;

import com.codegym.repositories.IOrdersRepository;
import com.codegym.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrdersRepository ordersRepository;
}
