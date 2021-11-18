package com.codegym.entity.employee;

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
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer levelId;

    private String levelName;

    @JsonBackReference(value = "level_employee")
    @OneToMany(mappedBy = "level")
    private Set<Employee> employeeSet;

}
