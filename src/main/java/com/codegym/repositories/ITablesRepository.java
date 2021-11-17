package com.codegym.repositories;

import com.codegym.entity.table.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ITablesRepository extends JpaRepository<Tables,Integer> {
    @Modifying
    @Query(value ="UPDATE `tables` SET `on_service` = 1 WHERE (`table_id` = ?1);\n",nativeQuery = true)
    void callFood(int id);

    @Modifying
    @Query(value ="UPDATE `tables` SET `on_service` = 2 WHERE (`table_id` = ?1);\n",nativeQuery = true)
    void callEmployee(int id);

    @Modifying
    @Query(value ="UPDATE `tables` SET `on_service` = 3 WHERE (`table_id` = ?1);\n",nativeQuery = true)
    void callPay(int id);

    @Query(value = "select *\n" +
            "from `tables`\n" +
            "where table_status = 'Trống'\n" +
            "order by rand()\n" +
            "LIMIT 1;",nativeQuery = true)
    Optional<Tables> getTable();


}
