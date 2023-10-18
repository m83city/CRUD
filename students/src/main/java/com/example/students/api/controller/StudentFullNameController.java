package com.example.students.api.controller;

import com.example.students.domain.StudentFullName;
import com.example.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class StudentFullNameController {
    private final StudentService studentService;

    @GetMapping("/student-full-name/{id}")
    public StudentFullName getFullName(@PathVariable Integer id) {
        if (isNull(id)) {
            throw new RuntimeException("Student Id is null");
        }
        return studentService.getStudentFullName(id);
    }
}
