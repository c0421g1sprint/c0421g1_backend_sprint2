package com.codegym.services.impls;

import com.codegym.entity.table.Tables;
import com.codegym.repositories.ITablesRepository;
import com.codegym.services.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements ITableService {
    @Autowired //BaoHG
    ITablesRepository tablesRepository;


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
    public List<Tables> checkTableCode(String tableCode) {
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

    //BaoHG
    @Override
    public void callFoodAndDrink(int id) {
        this.tablesRepository.callFood(id);
    }

    @Override // BaoHG
    public void callEmp(int id) {
        this.tablesRepository.callEmployee(id);
    }

    @Override // BaoHG
    public void pay(int id) {
        this.tablesRepository.callPay(id);
    }

    @Override
    public Optional<Tables> tableRandom() {
        return this.tablesRepository.getTable();
    }

    //
    @Override
    public Tables findByIdQuery(int tableId) {
        return tablesRepository.findByIdTableByQuery(tableId).orElse(null);
    }
}
