package com.codegym.services;

import com.codegym.entity.table.Tables;

public interface ITableService {
    void saveQuery(String location, String maximumCapacity,String tableCode);
    void updateTable(Tables tables);
    String checkTableCode(String tableCode);
}
