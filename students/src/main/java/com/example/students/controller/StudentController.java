package com.example.students.controller;

import com.example.students.model.StudentDTO;
import com.example.students.model.StudentEntity;
import com.example.students.model.StudentFullName;
import com.example.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/student/{id}/name/full")
    public StudentFullName getFullName (@PathVariable Integer id) {
        if(isNull(id)){
            throw new RuntimeException("Student Id is null");
        }
        return studentService.getStudentFullName(id);
    }
    @GetMapping("/student")
    public List<StudentEntity> getAll() {
        return studentService.getAllStudents();
    }
    @PostMapping("/student")
    public ResponseEntity<StudentDTO> create (@RequestBody StudentDTO studentDTO){
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
    public StudentDTO updateById (@PathVariable Integer id, @RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(id, studentDTO);
    }
    @DeleteMapping("/student/{id}")
    public Integer deleteById (@PathVariable Integer id) {
        return studentService.deleteStudentById(id);
    }
}