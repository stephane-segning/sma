package com.ssegning.school.schoolmanagementapp.api.impl;

import com.ssegning.school.schoolmanagementapp.api.StudentApi;
import com.ssegning.school.schoolmanagementapp.mapper.StudentMapper;
import com.ssegning.school.schoolmanagementapp.model.CreateStudent;
import com.ssegning.school.schoolmanagementapp.model.Student;
import com.ssegning.school.schoolmanagementapp.model.UpdateStudent;
import com.ssegning.school.schoolmanagementapp.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudentApiImpl implements StudentApi {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    @Override
    public Student createStudent(CreateStudent createStudent) {
        var toBeCreated = studentMapper.toEntity(createStudent);
        var created = studentRepo.save(toBeCreated);
        return studentMapper.toModel(created);
    }

    @Override
    public void deleteOneStudent(String studentId) {
        studentRepo.deleteById(studentId);
    }

    @Override
    public Student getOneStudent(String studentId) {
        var entity = studentRepo.findById(studentId).orElseThrow();
        return studentMapper.toModel(entity);
    }

    @Override
    public List<Student> getStudents(Integer page, Integer size) {
        var pageRequest = PageRequest.of(page, size);
        var students = studentRepo.findAll(pageRequest);
        return students.map(studentMapper::toModel).getContent();
    }

    @Override
    public Student updateStudent(String studentId, UpdateStudent updateStudent) {
        if (!studentRepo.existsById(studentId)) {
            throw new RuntimeException("Student not found");
        }

        var toBeUpdated = studentMapper.toEntity(updateStudent);
        toBeUpdated.setId(studentId);
        var updated = studentRepo.save(toBeUpdated);
        return studentMapper.toModel(updated);
    }
}
