package com.example.students.api.controller;

import com.example.students.api.dto.StudentDTO;
import com.example.students.api.mapper.StudentAPIMapper;
import com.example.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/student/{id}")
    public StudentDTO getAll(@PathVariable Integer id) {
      return  StudentAPIMapper.asStudentDTO(studentService.getStudentById(id));
    }

    @PutMapping("/student/{id}")
    public StudentDTO updateById (@PathVariable Integer id, @RequestBody StudentDTO studentDTO){
        return StudentAPIMapper.asStudentDTO(studentService.updateStudent(id, studentDTO));
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDTO> create (@RequestBody StudentDTO studentDTO){
        if(isNull(studentDTO.getAge())){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .eTag("HELLO WOLRD") // write body
                    .build();
        }
        //StudentDTO response = studentService.createStudent(studentDTO);
        StudentDTO responseMod = StudentAPIMapper
                .asStudentDTO(studentService
                        .createStudent(StudentAPIMapper
                                .asStudent(studentDTO)));
        return ResponseEntity.ok(responseMod);
    }

    @DeleteMapping("/student/{id}")
    public Integer deleteById (@PathVariable Integer id) {
        return studentService.deleteStudentById(id);
    }
}