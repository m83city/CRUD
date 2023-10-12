package com.example.getFieldName.controller;

import com.example.getFieldName.service.StudentNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class StudentNameController {
    private final StudentNameService nameService;
    @GetMapping("/name/{id}")
    public String getStudentNameById (@PathVariable Long id) {
        return nameService.getStudentNameById(id).getStudentName();
    }
}