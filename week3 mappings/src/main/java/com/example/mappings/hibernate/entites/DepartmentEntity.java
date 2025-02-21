package com.example.mappings.hibernate.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.util.Lazy;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String title;

    @OneToOne
    @JoinColumn(name = "manager-id")
    private EmployeeEntity manager;


    @OneToMany(mappedBy = "workerDepartment")
    private List<EmployeeEntity> workers;
}
