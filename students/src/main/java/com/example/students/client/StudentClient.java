package com.example.students.client;

import com.example.students.client.dto.StudentClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "jplaceholder", url = "{path.urlLastNameService}")//todo extract url into application.yml /done
public interface StudentClient {

    @GetMapping("/student-last-name/{id}")
//todo why do you have such mapping you're getting StudentClientDTO /done
    String getStudentLastName(@PathVariable Integer id);
}