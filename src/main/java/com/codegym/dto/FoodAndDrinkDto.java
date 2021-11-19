package com.codegym.dto;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.order.OrderDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodAndDrinkDto {
    private Integer fadId;

    private String fadName;

    private String fadImage;

    private boolean deleteFlag;

    private String fadCode;

    private double fadPrice;

    private Integer fadWaitTime;

    private Category category;

    Set<OrderDetail> orderDetails;
}
