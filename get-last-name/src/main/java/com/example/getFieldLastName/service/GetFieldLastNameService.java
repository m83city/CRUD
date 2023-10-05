package com.example.getFieldLastName.service;

import com.example.getFieldLastName.entity.GetFieldLastNameEntity;
import com.example.getFieldLastName.repository.GetFieldLastNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetFieldLastNameService {
    private final GetFieldLastNameRepository studentRepository;

    public Optional<GetFieldLastNameEntity> getFieldLastNameById(Integer id){
        return studentRepository.findById(id);
    }

}
