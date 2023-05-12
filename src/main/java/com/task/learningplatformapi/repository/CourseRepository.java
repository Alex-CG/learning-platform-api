package com.task.learningplatformapi.repository;

import com.task.learningplatformapi.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CustomCrud<Course, Long> {
}
