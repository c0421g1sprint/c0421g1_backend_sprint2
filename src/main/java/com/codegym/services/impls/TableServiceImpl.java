package com.codegym.services.impls;

import com.codegym.repositories.ITablesRepository;
import com.codegym.services.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements ITableService {
    @Autowired
    ITablesRepository tablesRepository;
}
