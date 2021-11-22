package com.codegym.repositories;

import com.codegym.dto.IncomeWithDateDto;
import com.codegym.dto.IncomesDto;
import com.codegym.entity.order.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IOrdersRepository extends JpaRepository<Orders, Integer> {

    //TaiNP
    @Query(value = "select  sum(o.quantity* fd.fad_price) as 'incomeWithDate' from order_detail as o join food_and_drink " +
            " as fd on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where os.create_date between " +
            " :startDate and :endDate", nativeQuery = true)
    IncomeWithDateDto findIncomeWithDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //TaiNP
    @Query(value = "select  sum(o.quantity* fd.fad_price) as 'incomes' from order_detail as o join food_and_drink as fd" +
            " on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where os.create_date = :dateNow" +
            " union (select  sum(o.quantity* fd.fad_price) as 'incomes' from order_detail as o" +
            " join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where" +
            " os.create_date between :monDay and :sunDay) union (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :firstMoth and :lastMonth) union" +
            " (select sum(o.quantity* fd.fad_price) as 'incomes' from order_detail as o join food_and_drink as fd" +
            " on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where os.create_date between :firstYear and :lastYear)", nativeQuery = true)
    List<IncomesDto> statisticsIncomes(@Param("dateNow") String dateNow, @Param("monDay") String monDay,
                                       @Param("sunDay") String sunDay, @Param("firstMoth") String firstMoth,
                                       @Param("lastMonth") String lastMonth, @Param("firstYear") String firstYear,
                                       @Param("lastYear") String lastYear);

    // TaiHVK coding change table on service status method 17/11/2021
    @Modifying
    @Transactional
    @Query(value = "update tables set tables.on_service = 0 where tables.table_id = :id", nativeQuery = true)
    void changeTableOnServiceStatus(int id);

    // TaiHVK coding reset table status method 17/11/2021
    @Modifying
    @Transactional
    @Query(value = "update tables set tables.table_status = 'Trống' where tables.table_id = :id", nativeQuery = true)
    void resetTableStatus(int id);

    // TaiHVK coding show table order detail method 17/11/2021
    @Query(value = "select * from `orders` inner join order_detail on `orders`.order_id = order_detail.order_id " +
            "inner join food_and_drink on food_and_drink.fad_id = order_detail.fad_id" +
            " inner join tables on `orders`.table_id = tables.table_id " +
            "where tables.table_id = :id",
            countQuery = "select count(*) from `orders` inner join order_detail on `orders`.order_id = order_detail.order_id " +
                    "inner join food_and_drink on food_and_drink.fad_id = order_detail.fad_id" +
                    " inner join tables on `orders`.table_id = tables.table_id where tables.table_id = :id", nativeQuery = true)
    Orders showOrderDetail(Integer id);

    //DanhNT: Tìm kiếm hoá đơn
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

    //DanhNT: Tìm hoá đơn theo ID
    @Query(value = "select order_id, create_date, order_code, employee_id, table_id\n" +
            "from orders\n" +
            "where order_id = ?1", nativeQuery = true)
    Optional<Orders> findById(Integer id);

    //BaoHG
    @Modifying // tạo trước 1 cái table vs order
    @Query(value = "insert into `orders` (table_id) value (?1);", nativeQuery = true)
    void createOrderTable(int tableId);

    //BaoHG
    @Query(value = "select * \n" +
            "from orders order by order_id desc limit 1;", nativeQuery = true)
    Optional<Orders> getNewOrder();

}
