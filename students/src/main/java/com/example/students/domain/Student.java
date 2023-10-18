package com.example.students.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Long id;

    private String firstName;

    private String secondName;

    private String lastName;

    private Integer age;

    private Integer course;
}