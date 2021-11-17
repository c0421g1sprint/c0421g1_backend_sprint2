package com.codegym.repositories;

import com.codegym.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    @Modifying
    @Query(value = "insert into order_detail(fad_id, quantity, order_id) value (?,?,?);", nativeQuery = true)
    void createOrderDetail(int fadId, int quantity, int orderId);
}
