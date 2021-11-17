package com.codegym.services;

import com.codegym.dto.IncomeWithDateDto;
import com.codegym.dto.IncomesDto;

import java.util.List;

public interface IOrderService {
    IncomeWithDateDto findIncomeWithDate(String startDate, String endDate);

    List<IncomesDto> statisticsIncomes(String dateNow, String monDay, String sunDay, String firstMoth, String lastMonth, String firstYear, String lastYear);

}
