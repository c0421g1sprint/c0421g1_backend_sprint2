package com.codegym.dto;

import com.codegym.entity.food_and_drink.Category;
import com.codegym.entity.order.OrderDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
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
    @NotEmpty(message = "Ảnh không được để trống")
    private String fadImage;
    private boolean deleteFlag;
    @NotEmpty(message = "Mã món không được để trống")
    private String fadCode;
    @NotNull(message = "Giá không được để trống")
    @DecimalMin(value = "5000", inclusive = false, message = "Giá phải lớn hơn 5.000 VNĐ")
    private Double fadPrice;
    private Integer fadWaitTime;
    private Category category;
    Set<OrderDetail> orderDetails;
}
