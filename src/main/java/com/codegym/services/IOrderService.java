package com.codegym.services;

import com.codegym.entity.order.Orders;
import com.codegym.entity.table.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {

    // TaiHVK coding show all available tables by list method 17/11/2021
    Page<Tables> showTableList(Pageable pageable);


    // TaiHVK coding change table on service status method 17/11/2021
    void changeTableOnServiceStatus(int id);


    // TaiHVK coding reset table status method 17/11/2021
    void resetTableStatus(int id);


    // TaiHVK coding show table order detail method 17/11/2021
    Orders showOrderDetail(Integer id);

    //DanhNT: tìm kiếm hoá đơn
    Page<Orders> findAllAdv(Pageable pageable, String date, String code);
}
