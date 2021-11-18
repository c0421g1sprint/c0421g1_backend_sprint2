package com.codegym.services.impls;

import com.codegym.entity.table.Tables;
import com.codegym.repositories.ITablesRepository;
import com.codegym.services.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements ITableService {
    @Autowired
private ITablesRepository tablesRepository;

    //DucLVH do at 17/11/2021
    @Override
    public void saveQuery(String location, String maximumCapacity, String tableCode) {
        this.tablesRepository.saveQuery(location,maximumCapacity,tableCode);
    }

    //DucLVH do at 17/11/2021
    @Override
    public void updateTable(Tables tables) {
        tablesRepository.updateTable(tables.getLocation(),tables.getMaximumCapacity(),tables.getTableCode(),tables.getTableStatus(),tables.isAvailableFlag(),tables.getTableId());
    }

    //DucLVH do at 17/11/2021
    @Override
    public String checkTableCode(String tableCode) {
        return this.tablesRepository.checkTableCode(tableCode);
    }

    //HauPT do at 17/11/2021
    @Override
    public Page<Tables> getListTable(Pageable pageable) {
        return tablesRepository.getListTable(pageable);
    }

    //HauPT do at 17/11/2021
    @Override
    public void deleteTableById(Integer id) {
        tablesRepository.deleteTableById(id);
    }

    //HauPT do at 17/11/2021
    @Override
    public Page<Tables> getListTableByCodeAndStatus(Pageable pageable, String tableCode, String tableStatus) {
        return tablesRepository.getListTableByCodeAndStatus(pageable,tableCode,tableStatus);
    }
}
