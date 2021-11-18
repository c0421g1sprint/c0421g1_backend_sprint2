package com.codegym.controllers;

import com.codegym.dto.IncomeWithDateDto;
import com.codegym.dto.IncomesDto;
import com.codegym.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.codegym.entity.order.Orders;
import com.codegym.entity.table.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping(value = "/income-date")
    public ResponseEntity<IncomeWithDateDto> showIncomeWithDate(@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate) throws ParseException {
        if (startDate == "" || endDate == ""){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        IncomeWithDateDto incomeWithDateDto = this.orderService.findIncomeWithDate(startDate, endDate);
        return new ResponseEntity<>(incomeWithDateDto, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/income-statistics")
    public ResponseEntity<List<IncomesDto>> statisticsIncome() {
        String monDay = "";
        String sunDay = "";
        String firstMoth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String lastMonth = "";
        String firstYear = LocalDate.of(LocalDate.now().getYear(), 1, 1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String lastYear = LocalDate.of(LocalDate.now().getYear(), 12, 31).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate dateNow = LocalDate.now();
        DayOfWeek date = dateNow.getDayOfWeek();

        if(LocalDate.now().getMonthValue() == 1|| LocalDate.now().getMonthValue() == 3|| LocalDate.now().getMonthValue() == 5||
                LocalDate.now().getMonthValue() == 7|| LocalDate.now().getMonthValue() == 8|| LocalDate.now().getMonthValue() == 10||
                LocalDate.now().getMonthValue() == 12){
            lastMonth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 31).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }else if(LocalDate.now().getMonthValue() == 2){
            lastMonth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 29).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }else {
            lastMonth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 30).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        if(date.name() == "MONDAY"){
            monDay = dateNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            sunDay = dateNow.plusDays(6).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(date.name() == "TUESDAY"){
            monDay = dateNow.minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            sunDay = dateNow.plusDays(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(date.name() == "WEDNESDAY"){
            monDay = dateNow.minusDays(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            sunDay = dateNow.plusDays(4).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(date.name() == "THURSDAY"){
            monDay = dateNow.minusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            sunDay = dateNow.plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(date.name() == "FRIDAY"){
            monDay = dateNow.minusDays(4).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            sunDay = dateNow.plusDays(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(date.name() == "SATURDAY"){
            monDay = dateNow.minusDays(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            sunDay = dateNow.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(date.name() == "SUNDAY"){
            monDay = dateNow.minusDays(6).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            sunDay = dateNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        List<IncomesDto> incomesDto = orderService.statisticsIncomes(dateNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), monDay, sunDay, firstMoth, lastMonth, firstYear, lastYear);
        return new ResponseEntity<>(incomesDto, HttpStatus.ACCEPTED);
    }


    // TaiHVK inject interfaces IOrderService 17/11/2021
    @Autowired
    private IOrderService iOrderService;


    // TaiHVK coding show all available tables by list method 17/11/2021
    @GetMapping(value = "/on-service")
    public ResponseEntity<Page<Tables>> showTableOnService(@PageableDefault(size = 6) Pageable pageable) {
        Page<Tables> tablesPage = this.iOrderService.showTableList(pageable);

        if (tablesPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tablesPage, HttpStatus.OK);
    }


    // TaiHVK coding change table on service status method 17/11/2021
    @PatchMapping(value = "/on-service/handle/{id}")
    public ResponseEntity<Void> changeTableOnServiceStatus(@PathVariable int id) {
        this.iOrderService.changeTableOnServiceStatus(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    // TaiHVK coding reset table status method 17/11/2021
    @PatchMapping(value = "/on-service/reset/{id}")
    public ResponseEntity<Void> changeTableStatus(@PathVariable int id) {
        this.iOrderService.resetTableStatus(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    // TaiHVK coding show table order detail method 17/11/2021
    @GetMapping(value = "/on-service/{id}")
    public ResponseEntity<Orders> showOrderDetail(@PathVariable(value = "id") Integer id) {
        Orders orders = this.iOrderService.showOrderDetail(id);

        if (orders == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    //DanhNT: Danh sách hoá đơn phân trang
    @GetMapping("/list/{orderCode}/{date}")
    public ResponseEntity<Page<Orders>> showList(@PageableDefault(value = 5) Pageable pageable,
            @PathVariable(required = false) String orderCode,
                                      @PathVariable(required = false) String date){
        if (orderCode.equals("null")){
            orderCode = null;
        }
        if (date.equals("null")){
            date = null;
        }
        Page<Orders> ordersList = this.iOrderService.findAllAdv(pageable, date, orderCode);
        if (!ordersList.getContent().isEmpty()){
            return new ResponseEntity<>(ordersList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
