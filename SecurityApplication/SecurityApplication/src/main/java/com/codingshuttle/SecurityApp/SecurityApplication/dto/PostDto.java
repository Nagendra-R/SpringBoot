package com.codingshuttle.SecurityApp.SecurityApplication.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDto {

    private Long id;
    private String title;
    private String description;

}
