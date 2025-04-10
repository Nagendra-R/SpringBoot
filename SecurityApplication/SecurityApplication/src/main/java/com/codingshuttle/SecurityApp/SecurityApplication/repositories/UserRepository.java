package com.codingshuttle.SecurityApp.SecurityApplication.repositories;

import com.codingshuttle.SecurityApp.SecurityApplication.entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserDetails> findByEmail(String username);
}
