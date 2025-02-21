package com.week4.prod_ready_features.com.week4.prod_ready_features.dto;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {


    private Long id;

    private String name;

    private String email;

    private int age;


    private String role;

    private Double salary;


    private LocalDate dateOfJoining;

    private Boolean isActive;



//    private Integer isPrime;
//
//    private String password;

}
