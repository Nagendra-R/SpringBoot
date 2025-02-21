package com.codingshuttle.SecurityApp.SecurityApplication.repositories;


import com.codingshuttle.SecurityApp.SecurityApplication.entites.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {

}
