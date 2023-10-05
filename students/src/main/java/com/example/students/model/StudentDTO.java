package com.example.students.model;

import lombok.*;

@Builder
@Data
public class StudentDTO { //This file is DTO

    private Integer id;

    private String firstName;

    private String secondName;

    private String lastName;

    private Integer age;

    private Integer course;
}
