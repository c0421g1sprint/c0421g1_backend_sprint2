package com.codegym.controllers;

import com.codegym.dto.TablesDto;
import com.codegym.entity.table.Tables;
import com.codegym.services.ITableService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/table")
public class TableController {
    @Autowired
    private ITableService tableService;

    @PostMapping(value = "/add")
    public ResponseEntity<List<FieldError>> createTable(@RequestBody TablesDto tablesDto) {
        String tableCode = tableService.checkTableCode(tablesDto.getTableCode());
        if (tableCode != null) {
            return new ResponseEntity<>(
                    HttpStatus.NOT_ACCEPTABLE);
        }
        Tables tables = new Tables();
        BeanUtils.copyProperties(tablesDto, tables);
        this.tableService.saveQuery(tables.getLocation(), tables.getMaximumCapacity(), tables.getTableCode());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateTeacher(@RequestBody @Validated TablesDto tablesDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Tables tables = new Tables();
            BeanUtils.copyProperties(tablesDto, tables);
            this.tableService.updateTable(tables);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
}

