package com.codegym.dto;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.order.OrderDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodAndDrinkDto {
    private Integer fadId;
    @NotEmpty(message = "Tên món không được để trống")
    @Size(min = 5, message = "Tên món không được ít hơn 5 chữ cái")
    private String fadName;
    @NotEmpty
    private String fadImage;
    private boolean deleteFlag;
    @NotEmpty
    private String fadCode;
    private Double fadPrice;
    private Integer fadWaitTime;

    private Category category;
    Set<OrderDetail> orderDetails;
}
