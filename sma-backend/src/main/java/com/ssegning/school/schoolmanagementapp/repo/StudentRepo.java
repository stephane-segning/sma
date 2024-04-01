package com.ssegning.school.schoolmanagementapp.repo;

import com.ssegning.school.schoolmanagementapp.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, String> {
}
