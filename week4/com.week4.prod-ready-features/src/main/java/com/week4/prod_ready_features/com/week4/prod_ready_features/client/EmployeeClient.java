package com.week4.prod_ready_features.com.week4.prod_ready_features.client;

import com.week4.prod_ready_features.com.week4.prod_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO admin);

    EmployeeDTO updateEmployee(Long employeeId,EmployeeDTO employeeDTO);

}
