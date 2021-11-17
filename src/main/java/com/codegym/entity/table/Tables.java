package com.codegym.entity.table;

import com.codegym.entity.order.Orders;
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
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tableId;

    private String tableCode;

    private boolean availableFlag;

    private String tableStatus;

    private boolean deleteFlag;

    private String location;

    private String maximumCapacity;

    private int onService;

    @JsonBackReference(value = "table_order")
    @OneToMany(mappedBy = "tables")
    private Set<Orders> orders;
}
