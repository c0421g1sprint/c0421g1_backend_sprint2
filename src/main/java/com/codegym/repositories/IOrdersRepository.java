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

    //DanhNT: Danh sách hoá đơn phân trang
    @Query(value = "select *\n" +
            "from orders o\n" +
            "where (?1 IS NULL OR o.create_date = ?1)\n" +
            "and (?2 IS NULL OR o.order_code like %?2%)",
            countQuery = "select count(*)\n" +
                    "from orders o\n" +
                    "where (?1 IS NULL OR o.create_date = ?1)\n" +
                    "and (?2 IS NULL OR o.order_code like %?2%)",
            nativeQuery = true)
    Page<Orders> findAllAdv(Pageable pageable, String date, String code);
}
