package com.ssegning.school.schoolmanagementapp.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;

@Data
@Entity
@Table(name = "courses")
public class CourseEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;

    @ManyToMany
    @CollectionTable(name = "course_participants", joinColumns = @JoinColumn(name = "course_id"))
    private Collection<StudentEntity> participants;

    @ManyToMany
    @CollectionTable(name = "course_teachers", joinColumns = @JoinColumn(name = "course_id"))
    private Collection<StaffEntity> teachers;
}
