package com.codegym.services;

import com.codegym.entity.table.Tables;

import java.util.List;
import java.util.Optional;


public interface ITableService {
    void callFoodAndDrink(int id); //BaoHG
    void callEmp(int id);//BaoHG
    void pay(int id);//BaoHG
    Optional<Tables> tableRandom();//BaoHG
}
