package com.example.getFieldName.service;

import com.example.getFieldName.entity.GetFieldNameDTO;
import com.example.getFieldName.entity.GetFieldNameEntity;
import com.example.getFieldName.repository.GetFieldNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class GetFieldNameService {
    private final GetFieldNameRepository studentRepository;

    public GetFieldNameDTO getStudentNameById (Long id) {
        if(isNull(id)){
            return null;
        }

       Optional<GetFieldNameEntity> nameEntity = studentRepository.findById(id);
        if(nameEntity.isPresent()){
            GetFieldNameDTO nameDTO = GetFieldNameDTO.builder()
                    .studentName(nameEntity.get().getStudentName())
                    .build();
            return nameDTO;
        }



    return null;
 }
}

