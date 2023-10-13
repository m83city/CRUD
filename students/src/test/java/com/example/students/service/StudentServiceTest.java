package com.example.students.service;

import com.example.students.repository.entity.StudentEntity;
import com.example.students.repository.jpa.StudentJPARepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @InjectMocks
    private StudentService service;
    @Mock
    private StudentJPARepository repository;


    @Test
    void givenStudent_whenRetrieveGetStudentById_thenReturnStudent() {
        //given
        StudentEntity  entity = new StudentEntity(1, "Hello", "hellow", "dsafd",1,1);
        int id = 1;
        Optional<StudentEntity> expected = Optional.of(entity);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(entity));
        //when
        var actual  = service.getStudentById(id);
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteStudentById() {
    }

    @Test
    void updateStudent() {
    }
}