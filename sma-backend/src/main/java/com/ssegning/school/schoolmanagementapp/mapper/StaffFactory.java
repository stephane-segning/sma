package com.ssegning.school.schoolmanagementapp.mapper;

import com.ssegning.school.schoolmanagementapp.domain.StaffEntity;
import com.ssegning.school.schoolmanagementapp.model.Staff;
import jdk.jfr.Name;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StaffFactory {

    private final JpaRepository<StaffEntity, String> repo;

    @ObjectFactory
    public StaffEntity factory(Staff staff) {
        if (staff.getId() != null) {
            return map(staff.getId());
        }
        return new StaffEntity();
    }

    @Name("idToStaffEntity")
    public StaffEntity map(String staffId) {
        return repo
                .findById(staffId)
                .orElseThrow(() -> new IllegalArgumentException("Staff with id " + staffId + " not found"));
    }
}
