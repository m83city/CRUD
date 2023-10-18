package com.example.students.api.dto;

import lombok.*;

@Builder
@Data
public class StudentDTO { //This file is DTO

    private Long id;

    private String firstName;

    private String secondName;

    private String lastName;

    private Integer age;

    private Integer course;
}