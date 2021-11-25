package com.codegym.services.impls;

import com.codegym.entity.table.Tables;
import com.codegym.repositories.ITablesRepository;
import com.codegym.services.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements ITableService {
    @Autowired //BaoHG
    ITablesRepository tablesRepository;

    @Override // BaoHG
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

    @Override //BaoHG
    public Optional<Tables> tableRandom() {
        return this.tablesRepository.getTable();
    }
}
