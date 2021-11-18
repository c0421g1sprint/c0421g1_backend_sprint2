package com.codegym.dto;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer categoryId;

    private String categoryName;

    private String categoryCode;

    private Set<FoodAndDrink> foodAndDrink;
}
