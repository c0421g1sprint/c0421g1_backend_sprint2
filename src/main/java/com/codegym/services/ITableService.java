package com.codegym.services;

import com.codegym.entity.table.Tables;

import java.util.List;
import java.util.Optional;


public interface ITableService {
    void callFoodAndDrink(int id);
    void callEmp(int id);
    void pay(int id);
    Optional<Tables> tableRandom();
}
