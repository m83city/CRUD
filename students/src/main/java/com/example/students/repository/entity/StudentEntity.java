package com.example.students.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "student")
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//todo all the ids should be Long /done

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "secondname")
    private String secondName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "course")
    private Integer course;
}