package com.example.students.repository;

import com.example.students.model.StudentLastName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(value = "jplaceholder", url = "http://student-last-name:8075")

public interface StudentClient {
   @GetMapping("/student-last-name/{id}")
    StudentLastName getStudentLastName(@PathVariable Integer id);
}