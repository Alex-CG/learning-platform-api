package com.task.learningplatformapi.repository;

import com.task.learningplatformapi.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CustomCrud<Student, Long> {
}
