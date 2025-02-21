package com.daily.code.buffer.springSecurity.controller;


import com.daily.code.buffer.springSecurity.entity.Student;
import com.daily.code.buffer.springSecurity.repository.UserRepository;
import com.daily.code.buffer.springSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/register")
    public Student register(@RequestBody Student student){
        Student savedStudent = userService.register(student);
        System.out.println("savedStudent = " + savedStudent);
        return savedStudent;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Student user){
        Optional<Student> savedStudent = userRepository.findByUsername(user.getUsername());

        if(savedStudent.isPresent()){
            System.out.println("savedStudent = " + savedStudent);
            return ResponseEntity.ok("login successfully");
        }
        return ResponseEntity.ok("Invalid Credentials");

    }



}
