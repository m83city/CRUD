package com.example.getFieldName.controller;

import com.example.getFieldName.service.GetFieldNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GetFieldNameController {
    private final GetFieldNameService nameService;
    @GetMapping("/name/{id}")
    public  String getStudentNameById (@PathVariable Long id) {
        nameService.getStudentNameById(id);
        return nameService.getStudentNameById(id).getStudentName();
    }
}
