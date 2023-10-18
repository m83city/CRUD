package com.example.students.service;

import com.example.students.client.StudentClientImpl;
import com.example.students.domain.Student;
import com.example.students.repository.StudentRepositoryImpl;
import com.example.students.domain.StudentFullName;
import com.example.students.repository.jpa.StudentJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentJPARepository studentJPARepository;
    private final StudentRepositoryImpl studentRepositoryImpl;
    private final StudentClientImpl client;

    public Student getStudentById(Integer id) {
        return studentRepositoryImpl.getStudentsById(id);
    }

    public Student updateStudent(Integer id, Student student) {//todo why do you need here DTO, and what do you update here /done
        return studentRepositoryImpl.updateStudent(id, student);
    }

    public Student createStudent(Student student) {
        return studentRepositoryImpl.createStudent(student);
    }

    public StudentFullName getStudentFullName(Integer id) {
        if (studentJPARepository.findById(id).isPresent()) {
            return StudentFullName.builder().firstName(client.getStudentNameById(id)).secondName(studentJPARepository.findById(id).get().getSecondName()).lastName(client.getStudentLastNameById(id)).build();
        } else {
            throw new RuntimeException();
        }
        //todo extract all this logic to different class lice StudentClient /done move to ../client/StudentClientImpl.class
    }

    public Integer deleteStudentById(Integer id) {
        studentJPARepository.deleteById(id);
        return id;
    }
}