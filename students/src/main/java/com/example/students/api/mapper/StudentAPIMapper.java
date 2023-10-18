package com.example.students.api.mapper;

import com.example.students.api.dto.StudentDTO;
import com.example.students.client.StudentClient;
import com.example.students.domain.Student;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentAPIMapper {
    //todo use MapStruct library
    private final StudentMapper structMapper;

    public Student DTOasStudent(StudentDTO studentDTO) { //example MapStruct
        return structMapper.studentDTOtoStudent(studentDTO);
    }

    public static StudentDTO asStudentDTO(Student student) {

        return StudentDTO
                .builder()
                .age(student.getAge())
                .course(student.getCourse())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .secondName(student.getSecondName())
                .id(student.getId())
                .build();
    }

    //todo auto format everything /done
    public static Student asStudent(StudentDTO studentDTO) {
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
