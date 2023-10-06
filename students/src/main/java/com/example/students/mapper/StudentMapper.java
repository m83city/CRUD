package com.example.students.mapper;

import com.example.students.model.StudentDTO;
import com.example.students.model.StudentEntity;
public class StudentMapper {

    public StudentEntity entityMapper(StudentDTO studentDTO){
        return StudentEntity.builder()
                .age(studentDTO.getAge())
                .course(studentDTO.getCourse())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .secondName(studentDTO.getSecondName())
                .build();
    }
    public StudentDTO dtoMapper(StudentEntity studentEntity){
       return StudentDTO.builder()
                .age(studentEntity.getAge())
                .course(studentEntity.getCourse())
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .secondName(studentEntity.getSecondName())
                .id(studentEntity.getId())
                .build();
    }
}

