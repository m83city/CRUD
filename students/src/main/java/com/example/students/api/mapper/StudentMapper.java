package com.example.students.api.mapper;

import com.example.students.api.dto.StudentDTO;
import com.example.students.domain.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentMapper {
    @Mapping(target = "age", source = "age")
    @Mapping(target = "course", source = "course")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "secondName",source = "secondName")
    @Mapping(target = "id", source = "id")
    StudentDTO studentToStudentDTO(Student student);

    @Mapping(target = "age", source = "age")
    @Mapping(target = "course", source = "course")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "secondName",source = "secondName")
    @Mapping(target = "id", source = "id")
    Student studentDTOtoStudent(StudentDTO studentDTO);
}

