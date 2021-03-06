package com.codegym.entity.food_and_drink;

import com.codegym.entity.order.OrderDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodAndDrink {
    @JsonBackReference(value = "items_orders")
    @OneToMany(mappedBy = "fad")
    Set<OrderDetail> orderDetails;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fadId;
    private String fadName;
    private String fadImage;
    private boolean deleteFlag;
    private String fadCode;
    private double fadPrice;
    private Integer fadWaitTime;
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id",referencedColumnName = "categoryId")
    private Category category;
}
