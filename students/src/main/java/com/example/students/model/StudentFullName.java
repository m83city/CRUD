package com.example.students.model;

import jakarta.persistence.Column;

import lombok.Builder;
import lombok.Data;

@Data
public class StudentFullName {
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "secondname")
    private String secondName;

    @Column(name = "lastName")
    private String lastName;
}