package com.ssegning.school.schoolmanagementapp.repo;

import com.ssegning.school.schoolmanagementapp.domain.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, String> {
}
