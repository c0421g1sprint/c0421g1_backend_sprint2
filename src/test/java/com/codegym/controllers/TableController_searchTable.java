package com.codegym.controllers;

import com.codegym.entity.table.Tables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureMockMvc
public class TableController_searchTable {

    @Autowired
    private TableController tableController;

    @Test
    public void searchTable_1()  {
        ResponseEntity<Page<Tables>> pageResponseEntity
                = this.tableController.searchTable(PageRequest.of(0, 5), null , null);
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Tables> tablesPage = pageResponseEntity.getBody();

        Assertions.assertEquals(20, tablesPage.getTotalElements());
        Assertions.assertEquals(4, tablesPage.getTotalPages());
        Assertions.assertEquals("TB-0001", tablesPage.getContent().get(1).getTableCode());
    }

    @Test
    public void searchTable_2()  {
        ResponseEntity<Page<Tables>> pageResponseEntity
                = this.tableController.searchTable(PageRequest.of(0, 5), "" , "");
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void searchTable_3()  {
        ResponseEntity<Page<Tables>> pageResponseEntity
                = this.tableController.searchTable(PageRequest.of(0, 5), "null" , "null");
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void searchTable_4()  {
        ResponseEntity<Page<Tables>> pageResponseEntity
                = this.tableController.searchTable(PageRequest.of(0, 5), "TB-0001" , null);
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Tables> tablesPage = pageResponseEntity.getBody();
        Assertions.assertEquals(2, tablesPage.getTotalElements());
        Assertions.assertEquals(1, tablesPage.getTotalPages());
        Assertions.assertEquals("TB-0001", tablesPage.getContent().get(1).getTableCode());
    }

}
