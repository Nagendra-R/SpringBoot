package com.example.mappings.hibernate.controllers;


import com.example.mappings.hibernate.entites.DepartmentEntity;
import com.example.mappings.hibernate.entites.EmployeeEntity;
import com.example.mappings.hibernate.service.EmployeeService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("")
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity){
        System.out.println("employeeEntity = " + employeeEntity);
        return employeeService.createNewEmployee(employeeEntity);
    }


}
