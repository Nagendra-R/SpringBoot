package com.week4.prod_ready_features.com.week4.prod_ready_features;

import com.week4.prod_ready_features.com.week4.prod_ready_features.client.EmployeeClient;
import com.week4.prod_ready_features.com.week4.prod_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest

class ApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	@Order(3)
	void getAllEmployeesTest(){
		List<EmployeeDTO> employees = employeeClient.getAllEmployees();
		System.out.println(employees);
	}

	@Test
	@Order(2)
	void getEmployeeByIdTest(){
		EmployeeDTO employeeDTO = employeeClient.getEmployeeById(10L);
		System.out.println(employeeDTO);
	}

	@Test
	@Order(1)
	void createNewEmployeeTest(){
		EmployeeDTO employeeDTO = employeeClient.createNewEmployee(
				new EmployeeDTO(null,
						"Nagendra",
						"nag@gamil.com",
						21,
						"ADMIN",
						20000.0,
						LocalDate.of(2020,11,12),
						true)
		);
		System.out.println(employeeDTO);

	}

	@Test
	void updateEmployeeById(){
		EmployeeDTO updatedEmployee = employeeClient.updateEmployee(1L,
				new EmployeeDTO(null,
						"venu",
						"venu@gamil.com",
						21,
						"ADMIN",
						20000.0,
						LocalDate.of(2020,11,12),
						true)
		);
		System.out.println(updatedEmployee);

	}

}
