package com.example.getFieldName.service;

import com.example.getFieldName.entity.NameDTO;
import com.example.getFieldName.entity.NameEntity;
import com.example.getFieldName.repository.NameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class NameService {
    private final NameRepository studentRepository;
    public NameDTO getStudentNameById (Long id) {
        if(isNull(id)){
            throw new RuntimeException("Student Id is null");
        }
       Optional<NameEntity> nameEntity = studentRepository.findById(id);
        if(nameEntity.isPresent()){
            NameDTO nameDTO = NameDTO.builder()
                    .studentName(nameEntity.get().getStudentName())
                    .build();
            return nameDTO;
        }
    return null;
 }
}