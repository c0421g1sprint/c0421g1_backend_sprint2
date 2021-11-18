package com.codegym.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TablesDto {
    private Integer tableId;
    private String tableCode;
    private String tableStatus;
    private String location;
    private String maximumCapacity;
    private boolean availableFlag;
    private boolean deleteFlag;
}
