package com.example.students.client;

import com.example.students.client.dto.StudentClientDTO;
import com.example.students.model.StudentLastName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(value = "jplaceholder", url = "http://student-last-name:8075")

public interface StudentClient {
   @GetMapping("/student-last-name/{id}")
   StudentClientDTO getStudentLastName(@PathVariable Integer id);
}