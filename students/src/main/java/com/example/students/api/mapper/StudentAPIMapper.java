package com.example.students.api.mapper;

import com.example.students.api.dto.StudentDTO;
import com.example.students.domain.Student;

public class StudentAPIMapper {
    public static StudentDTO asStudentDTO(Student student){
    return    StudentDTO
                .builder()
                .age(student.getAge())
                .course(student.getCourse())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .secondName(student.getSecondName())
                .id(student.getId())
                .build();
    }
    public static Student asStudent(StudentDTO studentDTO){
return Student
        .builder()
        .age(studentDTO.getAge())
        .course(studentDTO.getCourse())
        .firstName(studentDTO.getFirstName())
        .lastName(studentDTO.getLastName())
        .secondName(studentDTO.getSecondName())
        .id(studentDTO.getId())
        .build();
    }
}
