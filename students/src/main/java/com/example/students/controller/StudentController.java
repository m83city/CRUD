package com.example.students.controller;

import com.example.students.model.StudentDTO;
import com.example.students.model.StudentEntity;
import com.example.students.model.StudentFullName;
import com.example.students.model.StudentLastName;
import com.example.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final JSONPlaceHolderClient client;
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/student/{id}")
    public Optional<StudentEntity> getStudentById (@PathVariable Integer id){
        Optional<StudentEntity> studentEntity = studentService.getStudentById(id);
        return studentEntity;
    }















    @GetMapping("/student/{id}/name/full")
    public StudentFullName getFullStudentName (@PathVariable Integer id) {
        return studentService.getStudentFullName(id) ;
    }


    @GetMapping("/student/{id}/name/second")
    public String getStudentNameById (@PathVariable Integer id) {
        String resourceURL = "http://localhost:8085/name/1";
        System.out.println(resourceURL);
        System.out.println(restTemplate.getForEntity(resourceURL, String.class));


        return "Hello world";
    }





















    @GetMapping("/student/{id}/name/last")
    public StudentLastName getLastNameById (@PathVariable Integer id) {
    return client.getStudentLastName(id);
    }



    @PostMapping("/student")
    public ResponseEntity<StudentDTO> postStudent (@RequestBody StudentDTO studentDTO){
        //create validator
        if(isNull(studentDTO.getAge())){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .eTag("HELLO WOLRD") // write body
                    .build();
        }
        StudentDTO response = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/student/{id}")
    public StudentDTO updateStudentById (@PathVariable Integer id, @RequestBody StudentDTO studentDTO){
        System.out.println("PUT");
        return studentService.updateStudent(id, studentDTO);
    }
    @DeleteMapping("/student/{id}")
    public Integer deleteStudentById (@PathVariable Integer id) {
        return studentService.deleteStudentById(id);
    }
}
