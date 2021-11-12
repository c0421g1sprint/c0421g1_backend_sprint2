package com.codegym.entity;

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
public class FoodAndDrink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fadId;

    private String fadName;

    private String fadImage;

    private boolean deleteFlag;

    private String fadCode;

    private double price;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id",referencedColumnName = "categoryId")
    private Category category;
}
