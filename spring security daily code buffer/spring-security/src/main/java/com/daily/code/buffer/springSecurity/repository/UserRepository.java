package com.daily.code.buffer.springSecurity.repository;
import com.daily.code.buffer.springSecurity.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findByUsername(String username);
}
