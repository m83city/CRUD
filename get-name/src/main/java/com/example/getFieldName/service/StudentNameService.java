package com.example.getFieldName.service;

import com.example.getFieldName.dto.StudentNameDTO;
import com.example.getFieldName.repository.StudentNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class StudentNameService {
    private final StudentNameRepository studentRepository;
    public StudentNameDTO getStudentNameById (Long id) {
        if(isNull(id)){
            throw new RuntimeException("Student Id is null");
        }

        return studentRepository.findById(id)
                .map(entity -> StudentNameDTO.builder()
                .studentName(entity.getStudentName())
                .build())
                .orElse(null);
    }
}