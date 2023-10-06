package com.example.getFieldLastName.controller;

import com.example.getFieldLastName.entity.LastNameEntity;
import com.example.getFieldLastName.service.LastNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Controller
public class LastNameController {
    private final LastNameService nameService;
    @GetMapping("/student-last-name/{id}")
    public Optional<LastNameEntity> getStudentNameById (@PathVariable Integer id) {
        return nameService.getFieldLastNameById(id);
    }
}