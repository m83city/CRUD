package com.example.students.service;

import com.example.students.mapper.StudentMapper;
import com.example.students.repository.StudentClient;
import com.example.students.model.StudentDTO;
import com.example.students.model.StudentEntity;
import com.example.students.model.StudentFullName;
import com.example.students.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentClient client;
    StudentMapper studentMapper = new StudentMapper();
    public StudentFullName getStudentFullName (Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        StudentFullName fullName = new StudentFullName();

        String resourceURL = String.format("http://name:8085/name/%d", id);// service: first-name
        final String firstName = restTemplate.getForObject(resourceURL, String.class);
        fullName.setFirstName(firstName);

        if(studentRepository.findById(id).isPresent()){
            fullName.setSecondName(studentRepository.findById(id).get().getSecondName());
        }

        fullName.setLastName(client.getStudentLastName(id).getLastName());//service: last-name
        return fullName;
    }
    public StudentDTO createStudent(StudentDTO studentDTO){ //move to another method

        return studentMapper
                .dtoMapper(studentRepository
                                .save(studentMapper
                                                .entityMapper(studentDTO)
                                )
                );
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
        return studentMapper.dtoMapper(studentEntity);
    }
}