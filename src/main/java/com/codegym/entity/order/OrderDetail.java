package com.codegym.entity.order;

import com.codegym.entity.food_and_drink.FoodAndDrink;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @EmbeddedId
    private OrderDetailKey orderDetailId;

    @JsonBackReference(value = "order_detail")
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @MapsId("fadId")
    @JoinColumn(name = "fad_id")
    private FoodAndDrink fad;

    private int quantity;
}
