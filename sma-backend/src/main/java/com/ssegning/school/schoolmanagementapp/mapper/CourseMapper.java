package com.ssegning.school.schoolmanagementapp.mapper;

import com.ssegning.school.schoolmanagementapp.domain.CourseEntity;
import com.ssegning.school.schoolmanagementapp.model.Course;
import com.ssegning.school.schoolmanagementapp.model.CreateCourse;
import com.ssegning.school.schoolmanagementapp.model.UpdateCourse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                StaffMapper.class,
                StudentMapper.class,
                StaffFactory.class,
                StudentFactory.class,
        }
)
public interface CourseMapper {
    Course toModel(CourseEntity entity);

    CourseEntity toEntity(Course model);

    CourseEntity toEntity(CreateCourse model);

    CourseEntity toEntity(UpdateCourse model);
}
