package com.example.getFieldName.repository;
import com.example.getFieldName.entity.NameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<NameEntity, Long>{}