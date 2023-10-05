package com.example.students.service;

import com.example.students.controller.JSONPlaceHolderClient;
import com.example.students.model.StudentDTO;
import com.example.students.model.StudentEntity;
import com.example.students.model.StudentFullName;
import com.example.students.repository.StudentLastNameRepository;
import com.example.students.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentLastNameRepository lastNameRepository;
    private final JSONPlaceHolderClient client;

    public StudentFullName getStudentFullName (Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        StudentFullName fullName = new StudentFullName();

        String resourceURL = String.format("http://name:8085/name/%d", id);// service: first-name

        final String firstName = restTemplate.getForObject(resourceURL, String.class);
        fullName.setFirstName(firstName);

        if(studentRepository.findById(id).isPresent()){
            fullName.setSecondName(studentRepository.findById(id).get().getSecondName());
        }

       fullName.setLastName(client.getStudentLastName(id).getLastName());

        return fullName;
    }





    public StudentDTO createStudent(StudentDTO studentDTO){ //move to another method
       StudentEntity stud = StudentEntity.builder() //start
                .age(studentDTO.getAge())
                .course(studentDTO.getCourse())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .secondName(studentDTO.getSecondName())
                .build(); //finish
        StudentEntity studentEntity =  studentRepository.save(stud);
        return StudentDTO.builder()
                .age(studentEntity.getAge())
                .course(studentEntity.getCourse())
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .secondName(studentEntity.getSecondName())
                .id(studentEntity.getId())
                .build();
    }
    public List<StudentEntity> getAllStudents(){
        return studentRepository.findAll();
    }
    public Optional<StudentEntity> getStudentById(Integer id){
        return studentRepository.findById(id);
    }
    public Integer deleteStudentById (Integer id){
        studentRepository.deleteById(id);
        return  id;
    }
    public StudentDTO updateStudent (Integer id, StudentDTO studentDTO){
            StudentEntity studentEntity = studentRepository.getReferenceById(id);
            studentEntity.setAge(studentDTO.getAge());
            studentEntity.setCourse(studentDTO.getCourse());
            studentEntity.setFirstName(studentDTO.getFirstName());
            studentEntity.setSecondName(studentDTO.getSecondName());
            studentEntity.setLastName(studentDTO.getLastName());
            studentRepository.save(studentEntity);
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
