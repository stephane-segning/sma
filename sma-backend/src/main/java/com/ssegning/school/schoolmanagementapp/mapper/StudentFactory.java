package com.ssegning.school.schoolmanagementapp.mapper;

import com.ssegning.school.schoolmanagementapp.domain.StudentEntity;
import com.ssegning.school.schoolmanagementapp.model.Student;
import jdk.jfr.Name;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentFactory {

    private final JpaRepository<StudentEntity, String> repo;

    @ObjectFactory
    public StudentEntity factory(Student student) {
        if (student.getId() != null) {
            return map(student.getId());
        }
        return new StudentEntity();
    }

    @Name("idToStudentEntity")
    public StudentEntity map(String studentId) {
        return repo
                .findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student with id " + studentId + " not found"));
    }
}
