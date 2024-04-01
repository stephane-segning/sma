package com.ssegning.school.schoolmanagementapp.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;

@Data
@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @ManyToMany(mappedBy = "participants")
    private Collection<CourseEntity> courses;
}
