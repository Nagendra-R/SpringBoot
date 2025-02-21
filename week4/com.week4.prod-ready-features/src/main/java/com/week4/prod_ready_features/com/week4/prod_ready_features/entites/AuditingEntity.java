package com.week4.prod_ready_features.com.week4.prod_ready_features.entites;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditingEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(nullable = false,updatable = false)
    private String createdBy;


    @LastModifiedDate
    private LocalDateTime updatedDate;

    @LastModifiedBy
    private String updateBy;
}
