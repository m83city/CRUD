package com.example.students.repository.mapper;

import com.example.students.domain.Student;
import com.example.students.repository.entity.StudentEntity;

public class StudentRepoMapper {
    public static StudentEntity asStudentEntity(Student student) {
        return StudentEntity
                .builder()
                .age(student.getAge())
                .course(student.getCourse())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .secondName(student.getSecondName())
                .id(student.getId())
                .build();
    }

    public static Student asStudent(StudentEntity studentEntity) {
        return Student
                .builder()
                .age(studentEntity.getAge())
                .course(studentEntity.getCourse())
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .secondName(studentEntity.getSecondName())
                .id(studentEntity.getId())
                .build();
    }
}
