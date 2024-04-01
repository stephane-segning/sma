package com.ssegning.school.schoolmanagementapp.mapper;

import com.ssegning.school.schoolmanagementapp.domain.CourseEntity;
import com.ssegning.school.schoolmanagementapp.model.Course;
import com.ssegning.school.schoolmanagementapp.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseFactory {

    private final CourseRepo courseRepo;

    @ObjectFactory
    public CourseEntity factory(Course course) {
        if (course.getId() != null) {
            return factory(course.getId());
        }
        return new CourseEntity();
    }

    public CourseEntity factory(String courseId) {
        return courseRepo
                .findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course with id " + courseId + " not found"));
    }
}
