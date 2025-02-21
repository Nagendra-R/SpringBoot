package com.example.mappings.hibernate.service;


import com.example.mappings.hibernate.entites.DepartmentEntity;
import com.example.mappings.hibernate.entites.EmployeeEntity;
import com.example.mappings.hibernate.repository.DepartmentRepository;
import com.example.mappings.hibernate.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private  final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity) {
//        System.out.println("departmentEntity = " + departmentEntity);
//        System.out.println(departmentEntity.toString());
        return departmentRepository.save(departmentEntity);
    }


    public DepartmentEntity assignManagerToDepartment(Long employeeId, Long departmentId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

//        return departmentEntity.flatMap(department->
//            employeeEntity.map(employee->{
//                department.setManager(employee);
//                return departmentRepository.save(department);
//            })
//        );

        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee -> {
                    department.setManager(employee);
                    return departmentRepository.save(department);
                })).orElse(null);

    }

    public DepartmentEntity assignedDepartmentOfManager(Long employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        return employeeEntity.map(employee ->{
            return departmentRepository.findByManager(employee);
        }).orElse(null);
    }

    public DepartmentEntity assignWorkerToDepartment(Long employeeId, Long departmentId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);

        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee ->{
                    employee.setWorkerDepartment(department);
                    employeeRepository.save(employee);

                    department.getWorkers().add(employee);
                    return department;
                        })).orElse(null);

    }
}
