package com.example.students.service;

import com.example.students.domain.Student;
import com.example.students.client.StudentClient;
import com.example.students.api.dto.StudentDTO;
import com.example.students.repository.StudentRepository;
import com.example.students.model.StudentFullName;
import com.example.students.repository.jpa.StudentJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentJPARepository studentJPARepository;
    private final StudentRepository studentRepository;
    private final StudentClient client;
    @Value("${path.url}")
    private String url;

    public Student getStudentById(Integer id){
        return studentRepository.getStudentsById(id);
    }

    public Student updateStudent (Integer id, StudentDTO studentDTO){//todo why do you need here DTO, and what do you update here
        return studentRepository.updateStudent(id);
    }

    public Student createStudent(Student student){
        return studentRepository.createStudent(student);
    }

    public StudentFullName getStudentFullName (Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        StudentFullName fullName = new StudentFullName();

        //todo extract all this logic to different class lice StudentClient
        String resourceURL = String.format(url, id);// service: first-name

        final String firstName = restTemplate.getForObject(resourceURL, String.class);
        fullName.setFirstName(firstName);

        if(studentJPARepository.findById(id).isPresent()){
            fullName.setSecondName(studentJPARepository.findById(id).get().getSecondName());
        }

        fullName.setLastName(client.getStudentLastName(id).getLastName());//service: last-name
        return fullName;
    }

    public Integer deleteStudentById (Integer id){
        studentJPARepository.deleteById(id);
        return  id;
    }
}