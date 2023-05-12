package com.task.learningplatformapi.repository;

import com.task.learningplatformapi.entity.Enrollment;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends CustomCrud<Enrollment, Long> {
}

