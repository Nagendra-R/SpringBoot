package com.example.mappings.hibernate.repository;


import com.example.mappings.hibernate.entites.DepartmentEntity;
import com.example.mappings.hibernate.entites.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByManager(EmployeeEntity employee);
}
