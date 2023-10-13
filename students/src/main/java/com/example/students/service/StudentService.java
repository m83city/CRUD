package com.example.students.service;

import com.example.students.api.mapper.StudentMapper;
import com.example.students.repository.StudentClient;
import com.example.students.api.dto.StudentDTO;
import com.example.students.repository.entity.StudentEntity;
import com.example.students.model.StudentFullName;
import com.example.students.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentClient client;
    @Value("${path.url}")
    private String url;

    public StudentFullName getStudentFullName (Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        StudentFullName fullName = new StudentFullName();

        String resourceURL = String.format(url, id);// service: first-name

        final String firstName = restTemplate.getForObject(resourceURL, String.class);
        fullName.setFirstName(firstName);

        if(studentRepository.findById(id).isPresent()){
            fullName.setSecondName(studentRepository.findById(id).get().getSecondName());
        }

        fullName.setLastName(client.getStudentLastName(id).getLastName());//service: last-name
        return fullName;
    }

    public StudentDTO createStudent(StudentDTO studentDTO){ //move to another method

        return StudentMapper
                .asDTOMapper(studentRepository
                        .save(StudentMapper
                                        .asStudentEntity(studentDTO)));
    }

    public List<StudentDTO> getAllStudents(){
        return StudentMapper.studentDTOListMapper(studentRepository.findAll());
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
            studentRepository.save(studentEntity);
        return StudentMapper.asDTOMapper(StudentMapper.asStudentEntity(studentDTO));
    }
}