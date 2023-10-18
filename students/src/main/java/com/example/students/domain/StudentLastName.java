package com.example.students.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentLastName {
    private Long id;//todo why do you have it in different folders model and domain, you need to have only one, it's the same /done
    private String lastName;
}
