package com.ssegning.school.schoolmanagementapp.api.impl;

import com.ssegning.school.schoolmanagementapp.api.CourseApi;
import com.ssegning.school.schoolmanagementapp.domain.CourseEntity;
import com.ssegning.school.schoolmanagementapp.mapper.CourseMapper;
import com.ssegning.school.schoolmanagementapp.model.Course;
import com.ssegning.school.schoolmanagementapp.model.CreateCourse;
import com.ssegning.school.schoolmanagementapp.model.UpdateCourse;
import com.ssegning.school.schoolmanagementapp.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CourseApiImpl implements CourseApi {

    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    @Override
    public Course createCourse(CreateCourse createCourse) {
        CourseEntity toBeCreated = courseMapper.toEntity(createCourse);
        CourseEntity created = courseRepo.save(toBeCreated);
        return courseMapper.toModel(created);
    }

    @Override
    public void deleteOneCourse(String courseId) {
        courseRepo.deleteById(courseId);
    }

    @Override
    public List<Course> getCourses(Integer page, Integer size) {
        var courses = courseRepo.findAll(PageRequest.of(page, size));
        return courses.map(courseMapper::toModel).getContent();
    }

    @Override
    public Course getOneCourse(String courseId) {
        CourseEntity entity = courseRepo.findById(courseId).orElseThrow();
        return courseMapper.toModel(entity);
    }

    @Override
    public Course updateCourse(String courseId, UpdateCourse updateCourse) {
        if (!courseRepo.existsById(courseId)) {
            throw new RuntimeException("Course not found");
        }

        var toBeUpdated = courseMapper.toEntity(updateCourse);
        toBeUpdated.setId(courseId);
        CourseEntity updated = courseRepo.save(toBeUpdated);
        return courseMapper.toModel(updated);
    }
}
