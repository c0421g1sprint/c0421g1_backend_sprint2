package com.codegym.repositories;

import com.codegym.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
            "where order_id = ? ", nativeQuery = true)
    Optional<OrderDetail> findOrderDetailById(int orderId);
}
