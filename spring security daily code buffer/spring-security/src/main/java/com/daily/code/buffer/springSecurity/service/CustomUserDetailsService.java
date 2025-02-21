package com.daily.code.buffer.springSecurity.service;

import com.daily.code.buffer.springSecurity.entity.CustomUserDetails;
import com.daily.code.buffer.springSecurity.entity.Student;
import com.daily.code.buffer.springSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(" user not found::  " + username));
        return new CustomUserDetails(user);
    }
}
