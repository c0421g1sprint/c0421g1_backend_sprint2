package com.codegym.services;

import com.codegym.entity.table.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ITableService {

    //DucLVH do at 17/11/2021
    void saveQuery(String location, String maximumCapacity, String tableCode);

    //DucLVH do at 17/11/2021
    void updateTable(Tables tables);

    //DucLVH do at 17/11/2021
    String checkTableCode(String tableCode);

    //HauPt do at 17/11/2021
    Page<Tables> getListTable(Pageable pageable);

    //HauPT do at 17/11/2021
    void deleteTableById(Integer id);

    //HauPT do at 17/11/2021
    Page<Tables> getListTableByCodeAndStatus(Pageable pageable, String tableCode, String tableStatus);

    //BaoHG
    void callFoodAndDrink(int id);

    //BaoHG
    void callEmp(int id);

    //BaoHG
    void pay(int id);

    //BaoHG
    Optional<Tables> tableRandom();
}
