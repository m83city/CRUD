package com.example.getFieldLastName.mapper;

import com.example.getFieldLastName.dto.LastNameDTO;
import com.example.getFieldLastName.entity.LastNameEntity;

public class LastNameMapper {
    public LastNameDTO dtoMapper (LastNameEntity lastNameEntity){
        return LastNameDTO.builder()
                .lastName(lastNameEntity.getLastName())
                .build();
    }
}
