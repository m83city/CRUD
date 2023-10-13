package com.example.students.repository;

import com.example.students.domain.Student;
import com.example.students.repository.jpa.StudentJPARepository;
import com.example.students.repository.mapper.StudentRepoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository

public class StudentRepository {
    private final StudentJPARepository studentRepository;

    public Student getStudentsById(Integer id){
        return StudentRepoMapper.asStudent(studentRepository.getReferenceById(id));
    }

    public Student updateStudent (Integer id) {
        return StudentRepoMapper.asStudent(studentRepository.save(studentRepository.getReferenceById(id)));
    }

    public Student createStudent (Student student){
        return StudentRepoMapper.asStudent(studentRepository.save(StudentRepoMapper.asStudentEntity(student)));
    }
}
