package com.codegym.services.impls;

import com.codegym.dto.IncomeWithDateDto;
import com.codegym.dto.IncomesDto;
import com.codegym.repositories.IOrdersRepository;
import com.codegym.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrdersRepository ordersRepository;

    @Override
    public IncomeWithDateDto findIncomeWithDate(String startDate, String endDate) {
        return ordersRepository.findIncomeWithDate(startDate, endDate);
    }

    @Override
    public List<IncomesDto> statisticsIncomes(String dateNow, String monDay, String sunDay, String firstMoth, String lastMonth, String firstYear, String lastYear) {
        return ordersRepository.statisticsIncomes(dateNow, monDay, sunDay, firstMoth, lastMonth, firstYear, lastYear);
    }
}
