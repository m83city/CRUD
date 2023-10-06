package com.example.getFieldLastName.repository;

import com.example.getFieldLastName.entity.LastNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LastNameRepository extends JpaRepository<LastNameEntity, Integer> {}