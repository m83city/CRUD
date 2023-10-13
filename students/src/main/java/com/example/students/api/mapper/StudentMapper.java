package com.example.students.api.mapper;

import com.example.students.api.dto.StudentDTO;
import com.example.students.repository.entity.StudentEntity;

import java.util.List;

public class StudentMapper {
    public static StudentEntity asStudentEntity(StudentDTO studentDTO){
        return StudentEntity.builder()
                .age(studentDTO.getAge())
                .course(studentDTO.getCourse())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .secondName(studentDTO.getSecondName())
                .build();
    }
    public static StudentDTO asDTOMapper(StudentEntity studentEntity){
       return StudentDTO.builder()
                .age(studentEntity.getAge())
                .course(studentEntity.getCourse())
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .secondName(studentEntity.getSecondName())
                .id(studentEntity.getId())
                .build();
    }
    public static List<StudentDTO> studentDTOListMapper(List<StudentEntity> studentEntityList) {
        return studentEntityList
                .stream()
                .map(StudentMapper::asDTOMapper)
                .toList();
    }
}