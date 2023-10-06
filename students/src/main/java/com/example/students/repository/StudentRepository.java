package com.example.students.repository;

import com.example.students.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {}