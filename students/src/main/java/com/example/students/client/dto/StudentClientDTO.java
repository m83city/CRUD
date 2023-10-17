package com.example.students.client.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentClientDTO {
    private Integer id;
    private String lastName;
}