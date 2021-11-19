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

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public boolean isAvailableFlag() {
        return availableFlag;
    }

    public void setAvailableFlag(boolean availableFlag) {
        this.availableFlag = availableFlag;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(String maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getOnService() {
        return onService;
    }

    public void setOnService(int onService) {
        this.onService = onService;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
