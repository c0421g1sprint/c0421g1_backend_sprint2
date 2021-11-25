package com.codegym.repositories;
import com.codegym.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into order_detail(fad_id,order_id,quantity) value (?1,?2,?3) ", nativeQuery = true)
    void createOrderDetail(int fadId,int orderId,int quantity);



    @Query(value = "select * \n" +
            "from order_detail\n" +
            "where order_id = ?1 ", nativeQuery = true)
    List<OrderDetail> findOrderDetailById(int orderId);



    @Modifying
    @Query(value = "delete from `order_detail`\n" +
            "where `order_id` = ?1", nativeQuery = true)
    void deleteOrderDetail(int id);




}
