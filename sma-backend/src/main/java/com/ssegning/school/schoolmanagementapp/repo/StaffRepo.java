package com.ssegning.school.schoolmanagementapp.repo;

import com.ssegning.school.schoolmanagementapp.domain.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepo extends JpaRepository<StaffEntity, String> {
}
