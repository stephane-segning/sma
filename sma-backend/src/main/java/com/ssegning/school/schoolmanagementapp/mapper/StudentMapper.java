package com.ssegning.school.schoolmanagementapp.mapper;

import com.ssegning.school.schoolmanagementapp.domain.StudentEntity;
import com.ssegning.school.schoolmanagementapp.model.CreateStudent;
import com.ssegning.school.schoolmanagementapp.model.Student;
import com.ssegning.school.schoolmanagementapp.model.UpdateStudent;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface StudentMapper {
    Student toModel(StudentEntity entity);

    StudentEntity toEntity(Student model);

    StudentEntity toEntity(CreateStudent model);

    StudentEntity toEntity(UpdateStudent model);
}
