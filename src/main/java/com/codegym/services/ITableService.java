package com.codegym.services;

import com.codegym.entity.table.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ITableService {
    void saveQuery(String location, String maximumCapacity,String tableCode);
    void updateTable(Tables tables);
    String checkTableCode(String tableCode);

    //HauPt do at 17/11/2021
    Page<Tables> getListTable(Pageable pageable);

    //HauPT do at 17/11/2021
    void deleteTableById(Integer id);

    //HauPT do at 17/11/2021
    Page<Tables> getListTableByCodeAndStatus(Pageable pageable, String tableCode , String tableStatus);
}
