package com.codegym.services.impls;

import com.codegym.entity.order.Orders;
import com.codegym.entity.table.Tables;
import com.codegym.repositories.IOrdersRepository;
import com.codegym.repositories.ITablesRepository;
import com.codegym.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    // TaiHVK inject interfaces IOrdersRepository and ITablesRepository 17/11/2021
    @Autowired
    private IOrdersRepository ordersRepository;
    @Autowired
    private ITablesRepository iTablesRepository;


    // TaiHVK coding show all available tables by list method 17/11/2021
    @Override
    public Page<Tables> showTableList(Pageable pageable) {
        return this.iTablesRepository.showTableList(pageable);
    }


    // TaiHVK coding change table on service status method 17/11/2021
    @Override
    public void changeTableOnServiceStatus(int id) {
        this.ordersRepository.changeTableOnServiceStatus(id);
    }


    // TaiHVK coding reset table status method 17/11/2021
    @Override
    public void resetTableStatus(int id) {
        this.ordersRepository.resetTableStatus(id);
    }


    // TaiHVK coding show table order detail method 17/11/2021
    @Override
    public Orders showOrderDetail(Integer id) {
        return this.ordersRepository.showOrderDetail(id);
    }

    //DanhNT: Danh sách hoá đơn phân trang
    @Override
    public Page<Orders> findAllAdv(Pageable pageable, String date, String code) {
        return this.ordersRepository.findAllAdv(pageable, date, code);
    }
}
