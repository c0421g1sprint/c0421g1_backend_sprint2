package com.codegym.repositories;

import com.codegym.entity.table.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ITablesRepository extends JpaRepository<Tables,Integer> {

    //DucLVH do at 17/11/2021
    @Transactional
    @Modifying
    @Query(value = "INSERT into tables (available_flag, delete_flag, location, maximum_capacity, table_code, table_status,on_Service) values (0,0,?1,?2,?3,'Tốt','0')", nativeQuery = true)
    void saveQuery(String location,String maximumCapacity,String tableCode);

    //DucLVH do at 17/11/2021
    @Query(value ="SELECT * FROM tables WHERE table_code = ?1",nativeQuery = true)
    String checkTableCode(String tableCode);

    //  HauPT do at 17/11/2021
    @Query(value ="SELECT * FROM `tables` WHERE delete_flag = 0",nativeQuery = true)
    Page<Tables> getListTable(Pageable pageable);

    //  HauPT do at 17/11/2021
    @Modifying
    @Query(value ="UPDATE `tables` SET delete_flag = 1  WHERE table_id = ?1",nativeQuery = true)
    void deleteTableById(Integer id);

    //  HauPT do at 17/11/2021
    @Query(value ="SELECT * FROM `tables` WHERE (table_code = ?1 OR ?1 IS NULL)\n" +
            "and (table_status = ?2 OR ?2 IS NULL)",nativeQuery = true)
    Page<Tables> getListTableByCodeAndStatus(Pageable pageable, String tableCode , String tableStatus);

    //DucLVH do at 17/11/2021
    @Modifying
    @Query(value = "update tables set location = ?1,maximum_capacity= ?2,table_code = ?3,table_status=?4,available_flag=?5 \n" +
            "where (table_id = ?6);", nativeQuery = true)
    void updateTable(String location, String maximumCapacity, String tableCode, String tableStatus, boolean availableFlag,Integer tableId);

    @Query(value = "select table_id,location, maximum_capacity, table_code, table_status, available_flag,delete_flag,on_Service "+
            "from tables where table_id = ?1", nativeQuery = true)
    Optional<Tables> findByIdTableByQuery(int id);
}
