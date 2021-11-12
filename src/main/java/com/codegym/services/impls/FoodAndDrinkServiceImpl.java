package com.codegym.services.impls;

import com.codegym.repositories.IFoodAndDrinkRepository;
import com.codegym.services.IFoodAndDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodAndDrinkServiceImpl implements IFoodAndDrinkService {
    @Autowired
    IFoodAndDrinkRepository foodAndDrinkRepository;
}
