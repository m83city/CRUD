package com.example.students.repository.jpa;

import com.example.students.repository.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentJPARepository extends JpaRepository<StudentEntity, Integer> {}