package com.example.getFieldLastName.controller;

import com.example.getFieldLastName.entity.GetFieldLastNameEntity;
import com.example.getFieldLastName.service.GetFieldLastNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Controller

public class GetFieldLastNameController {
    private final GetFieldLastNameService nameService;
    @GetMapping("/student-last-name/{id}")
    public Optional<GetFieldLastNameEntity> getStudentNameById (@PathVariable Integer id) {
        Optional<GetFieldLastNameEntity> nameEntity = nameService.getFieldLastNameById(id);
        return nameEntity;
    }
}
