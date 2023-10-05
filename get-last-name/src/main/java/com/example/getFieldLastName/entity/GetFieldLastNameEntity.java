package com.example.getFieldLastName.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class GetFieldLastNameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    @Column(name = "lastname")
    private String lastName;
}
