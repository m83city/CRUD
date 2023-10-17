package com.example.getFieldLastName.service;

import com.example.getFieldLastName.entity.LastNameEntity;
import com.example.getFieldLastName.repository.LastNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LastNameService {
    private final LastNameRepository studentRepository;

    public String getFieldLastNameById(Integer id){
        if(studentRepository.findById(id).isPresent()){
        return studentRepository.findById(id).get().getLastName();
        }
        else {
            throw new RuntimeException();
        }
    }
}