package com.codegym.repositories;

import com.codegym.entity.order.Orders;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IOrdersRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "select o.order_id, create_date, employee_id, o.table_id, fad_id\n" +
            "from orders o\n" +
            "join order_detail od on od.order_id = o.order_id\n" +
            "join `tables` tb on tb.table_id = o.table_id\n" +
            "where (?1 IS NULL OR tb.table_code like %?1%)\n" +
            "and (?2 IS NULL OR o.create_date =?2)",
            countQuery = "select COUNT(*) from orders o\n" +
                    "join order_detail od on od.order_id = o.order_id\n" +
                    "join `tables` tb on tb.table_id = o.table_id\n" +
                    "where (?1 IS NULL OR tb.table_code like %?1%)\n" +
                    "and (?2 IS NULL OR o.create_date =?2)",
            nativeQuery = true)
    Page<Orders> findAllAdv(Pageable pageable, String tableCode, String date);
}
