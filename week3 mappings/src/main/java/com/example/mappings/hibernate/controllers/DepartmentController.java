package com.example.mappings.hibernate.controllers;


import com.example.mappings.hibernate.entites.DepartmentEntity;
import com.example.mappings.hibernate.entites.EmployeeEntity;
import com.example.mappings.hibernate.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private  final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId){

        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping("")
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity){
        System.out.println("departmentEntity = " + departmentEntity.getTitle());
        return departmentService.createNewDepartment(departmentEntity);
    }

    @PutMapping("/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assignManagerToDepartment(employeeId,departmentId);
    }

    @GetMapping("/assignedDepartmentOfManager/{employeeId}")
    public DepartmentEntity assignedDepartmentOfManager(@PathVariable Long employeeId){
        return departmentService.assignedDepartmentOfManager(employeeId);
    }

    @PutMapping("/{departmentId}/worker/{employeeId}")
    public DepartmentEntity assignWorkerToDepartment(@PathVariable Long employeeId,@PathVariable Long departmentId){
        return departmentService.assignWorkerToDepartment(employeeId,departmentId);
    }


}
