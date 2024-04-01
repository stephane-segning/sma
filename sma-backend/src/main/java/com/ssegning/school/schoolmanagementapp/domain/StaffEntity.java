package com.ssegning.school.schoolmanagementapp.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;

@Data
@Entity
@Table(name = "staffs")
public class StaffEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @ElementCollection
    @CollectionTable(name = "staffs_roles", joinColumns = @JoinColumn(name = "staff_id"))
    private Collection<StaffRole> functions;

    @ManyToMany(mappedBy = "teachers")
    private Collection<CourseEntity> courses;
}
