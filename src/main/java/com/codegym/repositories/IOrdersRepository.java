package com.codegym.repositories;

import com.codegym.entity.order.Orders;

import com.codegym.entity.table.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface IOrdersRepository extends JpaRepository<Orders,Integer> {


    // TaiHVK coding change table on service status method 17/11/2021
    @Modifying
    @Transactional
    @Query(value = "update tables set tables.on_service = 0 where tables.table_id = :id",  nativeQuery = true)
    void changeTableOnServiceStatus(int id);


    // TaiHVK coding reset table status method 17/11/2021
    @Modifying
    @Transactional
    @Query(value = "update tables set tables.table_status = 'Trống' where tables.table_id = :id",  nativeQuery = true)
    void resetTableStatus(int id);


    // TaiHVK coding show table order detail method 17/11/2021
    @Query(value= "select * from `orders` inner join order_detail on `orders`.order_id = order_detail.order_id " +
            "inner join food_and_drink on food_and_drink.fad_id = order_detail.fad_id" +
            " inner join tables on `orders`.table_id = tables.table_id " +
            "where tables.table_id = :id",
            countQuery= "select count(*) from `orders` inner join order_detail on `orders`.order_id = order_detail.order_id " +
                    "inner join food_and_drink on food_and_drink.fad_id = order_detail.fad_id" +
                    " inner join tables on `orders`.table_id = tables.table_id where tables.table_id = :id", nativeQuery = true)
    Orders showOrderDetail(Integer id);

    public static void main(String[] args) {
        int run = 2;

        while (true) {
            int count = 0;
            for (int i = 1; i <= run; i++) {
                if (run % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(run);
            }
            if (run >= 100) {
                break;
            }
            run++;
        }
    }
}
