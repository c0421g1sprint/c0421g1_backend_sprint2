package com.codegym.repositories;

import com.codegym.entity.table.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ITablesRepository extends JpaRepository<Tables,Integer> {


    // TaiHVK coding show all available tables by list method 17/11/2021
    @Query(value = "select tables.table_id, tables.table_code , tables.available_flag, tables.delete_flag, tables.location as location, tables.maximum_capacity, tables.table_status, tables.on_service from tables " +
            " where tables.delete_flag = false order by tables.table_code ",
            countQuery = "select count(*) from tables " +
                    " where tables.delete_flag = false order by tables.table_code ",  nativeQuery = true)
    Page<Tables> showTableList(Pageable pageable);
}
