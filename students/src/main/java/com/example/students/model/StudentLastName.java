package com.example.students.model;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class StudentLastName {
    private Integer id;
    private String lastName;
}
