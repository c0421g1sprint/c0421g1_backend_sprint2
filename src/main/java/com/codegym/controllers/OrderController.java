package com.codegym.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.codegym.dto.IncomeWithDateDto;
import com.codegym.dto.IncomesDto;
import com.codegym.entity.order.OrderDetail;
import com.codegym.services.IOrderDetailService;
import com.codegym.services.IOrderService;
import com.codegym.services.ITableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Optional;

import com.codegym.entity.order.Orders;
import com.codegym.entity.table.Tables;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/order")
public class OrderController {

    // TaiHVK inject interfaces IOrderService 17/11/2021
    @Autowired
    private IOrderService iOrderService;

    //BaoHG
    @Autowired
    private ITableService iTableService;

    //BaoHG
    @Autowired
    private IOrderDetailService iOrderDetailService;


    //TaiNP coding show IncomeWithDate
    @GetMapping(value = "/income-date")
    public ResponseEntity<IncomeWithDateDto> showIncomeWithDate(@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate) throws ParseException {
        if (startDate.equals("") || endDate.equals("")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

        if(dateStart.after(dateEnd)){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        IncomeWithDateDto incomeWithDateDto = this.iOrderService.findIncomeWithDate(startDate, endDate);
        return new ResponseEntity<>(incomeWithDateDto, HttpStatus.ACCEPTED);
    }

    //TaiNP coding show statisticsIncome
    @GetMapping(value = "/income-statistics")
    public ResponseEntity<List<IncomesDto>> statisticsIncome(@RequestParam(required = false) String year) {

        DateTimeFormatter myForMat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String monDay = "";
        String sunDay = "";
        LocalDate dateNow = LocalDate.now();
        DayOfWeek date = dateNow.getDayOfWeek();

        if(year.equals("")){
            year = String.valueOf(LocalDate.now().getYear());
        }

        if(date.name().equals("MONDAY")){
            monDay = dateNow.format(myForMat);
            sunDay = dateNow.plusDays(6).format(myForMat);
        }else if(date.name().equals("TUESDAY")){
            monDay = dateNow.minusDays(1).format(myForMat);
            sunDay = dateNow.plusDays(5).format(myForMat);
        }else if(date.name().equals("WEDNESDAY")){
            monDay = dateNow.minusDays(2).format(myForMat);
            sunDay = dateNow.plusDays(4).format(myForMat);
        }else if(date.name().equals("THURSDAY")){
            monDay = dateNow.minusDays(3).format(myForMat);
            sunDay = dateNow.plusDays(3).format(myForMat);
        }else if(date.name().equals("FRIDAY")){
            monDay = dateNow.minusDays(4).format(myForMat);
            sunDay = dateNow.plusDays(2).format(myForMat);
        }else if(date.name().equals("SATURDAY")){
            monDay = dateNow.minusDays(5).format(myForMat);
            sunDay = dateNow.plusDays(1).format(myForMat);
        }else if(date.name().equals("SUNDAY")){
            monDay = dateNow.minusDays(6).format(myForMat);
            sunDay = dateNow.format(myForMat);
        }
        List<IncomesDto> incomesDto = iOrderService.statisticsIncomes(dateNow.toString(), monDay, sunDay, year);
        if(incomesDto.get(14) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(incomesDto, HttpStatus.ACCEPTED);
    }

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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // TaiHVK coding
    @GetMapping(value = "/on-service/sum-{id}")
    public ResponseEntity<Double> showOrderDetailSumMoney(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(this.iOrderService.sumTableBill(id), HttpStatus.OK);
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

    //DanhNT: Tìm hoá đơn theo ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Orders> showById(@PathVariable Integer id){
        Orders orders = this.iOrderService.findById(id);
        if (orders != null){
            return new ResponseEntity<>(orders,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //BaoHG
    @PatchMapping("/call-food/{id}")
    public void callFoodById(@PathVariable int id) {
        this.iTableService.callFoodAndDrink(id);
    }

    @PatchMapping("/call-employee/{id}") //BaoHG
    public void callEmployeeById(@PathVariable int id) {
        this.iTableService.callEmp(id);
    }

    @PatchMapping("/call-pay/{id}") //BaoHG
    public void callPayById(@PathVariable int id) {
        this.iTableService.pay(id);
    }

    //BaoHG
    @GetMapping("/table") // ley ra 1 cai ban bat ki neu no con trong
    public ResponseEntity<Optional<Tables>> getTable() {
        Optional<Tables> tables = this.iTableService.tableRandom();
        if (tables.isPresent()) {
            this.iOrderService.resetTableStatus2(tables.get().getTableId());
            return new ResponseEntity<>(tables, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    //BaoHG
    @PostMapping("/create/orderTable") // tao moi 1 thang order all null chi co value table
    public ResponseEntity<Orders> newOrderTable(@RequestBody Orders orders) {
        this.iOrderService.saveOrderTable(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //BaoHG
    @PostMapping("/create/orderDetail")
    public ResponseEntity<OrderDetail> newOrderDetail(@RequestBody OrderDetail orderDetail) {
        this.iOrderDetailService.saveOrderTail(orderDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //BaoHG
    @GetMapping("/list/orderNew") // lay ra thang order moi nhat
    public ResponseEntity<Optional<Orders>> getNewOrderDB() {
        Optional<Orders> list = this.iOrderService.listNewOrder();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //BaoHG
    @GetMapping("/list/order") // lay ra all order
    public ResponseEntity<List<Orders>> findAllOrder() {
        List<Orders> list = this.iOrderService.listOrder();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //BaoHG
    @GetMapping("/list/orderDetail") // lay ra all order detail
    public ResponseEntity<List<OrderDetail>> findAllOrderDetail() {
        List<OrderDetail> list = this.iOrderDetailService.listOrderDetail();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //BaoHG
    @GetMapping("orderDetail/{id}")
    public ResponseEntity<List<OrderDetail>> findByIdOrderDetail(@PathVariable int id) {
        List<OrderDetail> list = this.iOrderDetailService.findByOrderId(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping("delete/orderDetail/{id}") //  //BaoHG xoa 1 mon trong orderDetail
    public ResponseEntity<OrderDetail> newOrderDetail(@PathVariable int id) {
        List<OrderDetail> orderDetail = this.iOrderDetailService.findByOrderId(id);
        if (orderDetail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            this.iOrderDetailService.deleteOrderDetailByFadId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    // TaiHVK
    @PatchMapping(value = "/on-service/update/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable int id) {
        String code = "HD" + ((int) (Math.random() * 8999) + 1000);
        String date = new Date(System.currentTimeMillis()).toString();
        int idEmployee = (int) (Math.random() * 9) + 1;
        this.iOrderService.updateOrder(date, code, idEmployee, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
