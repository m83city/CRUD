package com.example.getFieldName.repository;
import com.example.getFieldName.entity.StudentNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentNameRepository extends JpaRepository<StudentNameEntity, Long>{}