package com.codegym.repositories;

import com.codegym.entity.table.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ITablesRepository extends JpaRepository<Tables,Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT into tables (available_flag, delete_flag, location, maximum_capacity, table_code, table_status) values (0,0,?1,?2,?3,'trong')", nativeQuery = true)
    void saveQuery(String location,String maximumCapacity,String tableCode);

    @Query(value ="SELECT * FROM tables WHERE table_code = ?1",nativeQuery = true)
    String checkTableCode(String tableCode);

    @Modifying
    @Query(value = "update tables set location = ?1,maximum_capacity= ?2,table_code = ?3,table_status=?4,available_flag=?5 \n" +
            "where (table_id = ?6);", nativeQuery = true)
    void updateTable(String location, String maximumCapacity, String tableCode, String tableStatus, boolean availableFlag,Integer tableId);
}
