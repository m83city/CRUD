package com.example.students.model;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class StudentLastName {
    private Integer id;//todo why do you have it in different folders model and domain, you need to have only one, it's the same
    private String lastName;
}
