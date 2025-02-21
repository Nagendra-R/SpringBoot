package com.week4.prod_ready_features.com.week4.prod_ready_features.repository;


import com.week4.prod_ready_features.com.week4.prod_ready_features.entites.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {

}
