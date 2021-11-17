package com.codegym.services.impls;

import com.codegym.entity.table.Tables;
import com.codegym.repositories.ITablesRepository;
import com.codegym.services.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements ITableService {
    @Autowired
private ITablesRepository tablesRepository;
    @Override
    public void saveQuery(String location, String maximumCapacity, String tableCode) {
        this.tablesRepository.saveQuery(location,maximumCapacity,tableCode);
    }

    @Override
    public void updateTable(Tables tables) {
        tablesRepository.updateTable(tables.getLocation(),tables.getMaximumCapacity(),tables.getTableCode(),tables.getTableStatus(),tables.isAvailableFlag(),tables.getTableId());
    }

    @Override
    public String checkTableCode(String tableCode) {
        return this.tablesRepository.checkTableCode(tableCode);
    }
}
