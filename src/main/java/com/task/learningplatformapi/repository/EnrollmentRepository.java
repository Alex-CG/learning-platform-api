package com.task.learningplatformapi.repository;

import com.task.learningplatformapi.model.Enrollment;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends CustomCrud<Enrollment, Long> {
}

