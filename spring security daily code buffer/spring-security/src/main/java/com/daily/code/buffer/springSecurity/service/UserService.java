package com.daily.code.buffer.springSecurity.service;


import com.daily.code.buffer.springSecurity.entity.Student;
import com.daily.code.buffer.springSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public Student register(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return userRepository.save(student);
    }
}
