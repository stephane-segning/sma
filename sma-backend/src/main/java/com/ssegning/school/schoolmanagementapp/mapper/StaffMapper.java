package com.ssegning.school.schoolmanagementapp.mapper;

import com.ssegning.school.schoolmanagementapp.domain.StaffEntity;
import com.ssegning.school.schoolmanagementapp.model.CreateStaff;
import com.ssegning.school.schoolmanagementapp.model.Staff;
import com.ssegning.school.schoolmanagementapp.model.UpdateStaff;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface StaffMapper {
    Staff toModel(StaffEntity entity);

    StaffEntity toEntity(Staff model);

    StaffEntity toEntity(CreateStaff model);

    StaffEntity toEntity(UpdateStaff model);
}
