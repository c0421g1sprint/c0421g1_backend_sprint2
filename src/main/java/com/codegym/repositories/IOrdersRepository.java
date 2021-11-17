package com.codegym.repositories;

import com.codegym.dto.IncomeWithDateDto;
import com.codegym.dto.IncomesDto;
import com.codegym.entity.order.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IOrdersRepository extends JpaRepository<Orders,Integer> {

    @Query(value = "select  sum(o.quantity* fd.fad_price) as 'incomeWithDate' from order_detail as o join food_and_drink " +
            " as fd on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where os.create_date between " +
            " :startDate and :endDate", nativeQuery = true)
    IncomeWithDateDto findIncomeWithDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "select  sum(o.quantity* fd.fad_price) as 'incomes' from order_detail as o join food_and_drink as fd" +
            " on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where os.create_date = :dateNow" +
            " union (select  sum(o.quantity* fd.fad_price) as 'incomes' from order_detail as o" +
            " join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where" +
            " os.create_date between :monDay and :sunDay) union (select  sum(o.quantity* fd.fad_price) as 'incomes'" +
            " from order_detail as o join food_and_drink as fd on o.fad_id = fd.fad_id join orders as os" +
            " on o.order_id = os.order_id where os.create_date between :firstMoth and :lastMonth) union" +
            " (select sum(o.quantity* fd.fad_price) as 'incomes' from order_detail as o join food_and_drink as fd" +
            " on o.fad_id = fd.fad_id join orders as os on o.order_id = os.order_id where os.create_date between :firstYear and :lastYear)",  nativeQuery = true)
    List<IncomesDto> statisticsIncomes(@Param("dateNow") String dateNow, @Param("monDay") String monDay,
                                       @Param("sunDay") String sunDay, @Param("firstMoth") String firstMoth,
                                       @Param("lastMonth") String lastMonth, @Param("firstYear") String firstYear,
                                       @Param("lastYear") String lastYear);
}
