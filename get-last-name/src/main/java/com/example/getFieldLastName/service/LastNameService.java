package com.example.getFieldLastName.service;

import com.example.getFieldLastName.dto.LastNameDTO;
import com.example.getFieldLastName.entity.LastNameEntity;
import com.example.getFieldLastName.mapper.LastNameMapper;
import com.example.getFieldLastName.repository.LastNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class LastNameService {
    private final LastNameRepository lastNameRepository;
        LastNameMapper mapper = new LastNameMapper();
    public LastNameDTO getFieldLastNameById(Integer id){
            Optional<LastNameEntity> lastNameEntityOptional = lastNameRepository.findById(id);

            if (lastNameEntityOptional.isPresent()){
            return mapper.dtoMapper(lastNameRepository.findById(id).get());
            }
        throw new RuntimeException("Something gone wrong");
    }
}