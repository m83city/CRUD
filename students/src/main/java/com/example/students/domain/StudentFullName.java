package com.example.students.domain;

import jakarta.persistence.Column;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentFullName {
    //todo why do you have it here /done
    private String firstName;

    private String secondName;

    private String lastName;
}