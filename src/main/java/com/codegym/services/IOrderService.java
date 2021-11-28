package com.codegym.services;

import com.codegym.dto.IncomeWithDateDto;
import com.codegym.dto.IncomesDto;

import java.util.List;

import com.codegym.entity.order.Orders;
import com.codegym.entity.table.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;


public interface IOrderService {

    //TaiNP coding find IncomeWithDate
    IncomeWithDateDto findIncomeWithDate(String startDate, String endDate);

    //TaiNP coding show statisticsIncome
    List<IncomesDto> statisticsIncomes(String dateNow, String monDay, String sunDay, String year);

    // TaiHVK coding show all available tables by list method 17/11/2021
    Page<Tables> showTableList(Pageable pageable);


    // TaiHVK coding change table on service status method 17/11/2021
    void changeTableOnServiceStatus(int id);


    // TaiHVK coding reset table status method 17/11/2021
    void resetTableStatus(int id);


    // TaiHVK coding show table order detail method 17/11/2021
    Orders showOrderDetail(Integer id);

    // TaiHVK coding show table sum method 21/11/2021
    Double sumTableBill(Integer id);

    //DanhNT: tìm kiếm hoá đơn
    Page<Orders> findAllAdv(Pageable pageable, String date, String code);

    //DanhNT: Tìm hoá đơn theo ID
    Orders findById(Integer id);

    //BaoHG
    List<Orders> listOrder();

    //BaoHG
    void saveOrderTable(Orders orders);

    //BaoHG
    Optional<Orders> listNewOrder();
    //TaiVK
    void resetTableStatus2(int id);

    // TaiHVK update order 27/11
    void updateOrder(String date, String code, int id, int tableId);
}