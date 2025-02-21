package com.week4.prod_ready_features.com.week4.prod_ready_features.client.impl;

import com.week4.prod_ready_features.com.week4.prod_ready_features.advices.APIResponse;
import com.week4.prod_ready_features.com.week4.prod_ready_features.client.EmployeeClient;
import com.week4.prod_ready_features.com.week4.prod_ready_features.dto.EmployeeDTO;
import com.week4.prod_ready_features.com.week4.prod_ready_features.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
public class EmployeeClientImpl implements EmployeeClient {


    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

//    fatal,error,warn,info,debug,trace log levels


    public EmployeeClientImpl(RestClient restClient) {
        this.restClient = restClient;
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {

//        log.error("error log");
//        log.warn("warn log");
//        log.info("info log");
//        log.debug("debug log");
//        log.trace("trace log");

        try {
            APIResponse<List<EmployeeDTO>> employees =
                    restClient.get()
                            .uri("allEmployees")
                            .retrieve()
                            .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                                log.error(new String(res.getBody().readAllBytes()));
                                throw new ResourceNotFoundException("get all employees is not executed");
                            })
                            .body(new ParameterizedTypeReference<>() {
                            });
            log.info("successfully reterived all employees");
            log.trace("Retrieved employees are :{} {}",employees.getData(),employees.getLocalDateTime());
            return employees.getData();
        } catch (Exception e) {
            log.error("Exception occurred in get all employees");
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.trace("trying to reterive get employee by id");
        try {
            APIResponse<EmployeeDTO> employeeDTO =
                    restClient.get()
                            .uri("employeeId/{employeeId}", employeeId)
                            .retrieve()
                            .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                                log.error(new String(res.getBody().readAllBytes()));
                                throw new ResourceNotFoundException("getEmployeeById is not executed with id :"+employeeId);
                            })
                            .body(new ParameterizedTypeReference<>() {
                            });
            return employeeDTO.getData();
        } catch (Exception e) {
            log.error("Exception occurred in get  employee By Id");
            throw new ResourceNotFoundException("employee not found");
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        log.trace("entered into create new Employee with {}",employeeDTO);
        try {
            ResponseEntity<APIResponse<EmployeeDTO>> createdEmployee =
                    restClient.post()
                            .uri("createEmployee")
                            .body(employeeDTO)
                            .retrieve()
                            .onStatus(HttpStatusCode::is4xxClientError,(req,res)->{
                                log.error(new String(res.getBody().readAllBytes()));
                                throw new ResourceNotFoundException("create new employee is not executed");
                            })
                            .toEntity(new ParameterizedTypeReference<>() {
                            });


            //return via responseEntity

            return createdEmployee.getBody().getData();
        } catch (Exception e) {
            log.error("employee is not created with employee {}",employeeDTO );
            throw new RuntimeException("employee cannot created");
        }
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        try {
            APIResponse<EmployeeDTO> updatedEmployee =
                    restClient.put()
                            .uri("updateEmployee/{id}", employeeId)
                            .body(employeeDTO)
                            .retrieve()
                            .body(new ParameterizedTypeReference<>() {
                            });
            return  updatedEmployee.getData();
        } catch (Exception e) {
            throw new RuntimeException("not updated");
        }
    }


}
