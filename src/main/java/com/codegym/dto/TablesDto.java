package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TablesDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tableId;
    @NotBlank
    private String tableCode;
    @NotBlank
    private String tableStatus;
    @NotBlank
    private String location;
    @NotBlank
    private String maximumCapacity;
    private boolean availableFlag;
    private boolean deleteFlag;
}
