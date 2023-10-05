package com.example.getFieldName.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table (name = "student")
public class GetFieldNameEntity {
    @Id
    private Integer id;

    @Column(name = "firstname")
    private String studentName;

}
