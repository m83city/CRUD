package com.example.students.repository;

import com.example.students.domain.Student;
import com.example.students.repository.entity.StudentEntity;
import com.example.students.repository.jpa.StudentJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.students.repository.mapper.StudentRepoMapper.*;

@RequiredArgsConstructor
@Repository

public class StudentRepositoryImpl {//todo call it like StudentRepositoryImpl /done

    private final StudentJPARepository studentRepository;

    public Student getStudentsById(Integer id) {
        return asStudent(studentRepository.getReferenceById(id)); //todo make it without StudentRepoMapper.class /done
    }

    public Student updateStudent(Integer id, Student student) {
        StudentEntity latestStudent = asStudentEntity(student);
        return asStudent(studentRepository.save(latestStudent));//todo extract it into different variables /done
    }

    public Student createStudent(Student student) {
        StudentEntity newStudent = asStudentEntity(student);
        return asStudent(studentRepository.save(newStudent));
    }
}