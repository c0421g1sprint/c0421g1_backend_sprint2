package com.codegym.repositories;

import com.codegym.dto.IncomeWithDateDto;
import com.codegym.dto.IncomesDto;
import com.codegym.entity.order.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes' from order_detail as o" +
            " join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where" +
            " os.create_date between :monDay and :sunDay)" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-01-01' and :year" +
            " '-01-31')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-02-01' and :year" +
            " '-02-29')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-03-01' and :year" +
            " '-03-31')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-04-01' and :year" +
            " '-04-30')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-05-01' and :year" +
            " '-05-31')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-06-01' and :year" +
            " '-06-30')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            "  '-07-01' and :year" +
            " '-07-31')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-08-01' and :year" +
            " '-08-31')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-09-01' and :year" +
            " '-09-30')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-10-01' and :year" +
            " '-10-31')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-11-01' and :year" +
            " '-11-30')" +
            " union all" +
            " (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :year" +
            " '-12-01' and :year" +
            " '-12-31')" +
            " union all" +
            " (select sum(o.quantity* fd.fad_price) as 'incomes' from order_detail as o join food_and_drink as fd" +
            " on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where os.create_date between :year" +
            " '-01-01' and :year" +
            " '-12-31')",  nativeQuery = true)
    List<IncomesDto> statisticsIncomes(@Param("dateNow") String dateNow,
                                       @Param("monDay") String monDay,
                                       @Param("sunDay") String sunDay,
                                       @Param("year") String year);
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

    // TaiHVK coding show table sum method 21/11/2021
    @Query(value = "select sum(food_and_drink.fad_price * order_detail.quantity) from tables\n" +
            "join orders on tables.table_id = orders.table_id \n" +
            "             join order_detail on order_detail.order_id = orders.order_id \n" +
            "             join food_and_drink on food_and_drink.fad_id = order_detail.fad_id\n" +
            "             group by tables.table_id\n" +
            "             having tables.table_id = :id", nativeQuery = true)
    Double sumTableBill(Integer id);

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

    @Modifying
    @Transactional
    @Query(value = "update tables set tables.table_status = 'Có Khách' where tables.table_id = :id", nativeQuery = true)
    void resetTableStatus2(int id);

    // TaiHVK bổ sung code 27/11
    @Modifying
    @Query(value = "update orders set create_date = ?1, order_code = ?2, employee_id = ?3 where table_id = ?4 ", nativeQuery = true)
    void updateOrder(String date, String code, int id, int tableId);


}