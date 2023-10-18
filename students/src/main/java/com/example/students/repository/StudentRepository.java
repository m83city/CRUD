package com.example.students.repository;

import com.example.students.domain.Student;
import com.example.students.repository.jpa.StudentJPARepository;
import com.example.students.repository.mapper.StudentRepoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository

public class StudentRepository {//todo call it like StudentRepositoryImpl

    private final StudentJPARepository studentRepository;

    public Student getStudentsById(Integer id){
        return StudentRepoMapper.asStudent(studentRepository.getReferenceById(id)); //todo make it without StudentRepoMapper.class
    }

    public Student updateStudent (Integer id) {
        return StudentRepoMapper.asStudent(studentRepository.save(studentRepository.getReferenceById(id)));//todo extract it into different variables
    }

    public Student createStudent (Student student){
        return StudentRepoMapper.asStudent(studentRepository.save(StudentRepoMapper.asStudentEntity(student)));
    }
}
