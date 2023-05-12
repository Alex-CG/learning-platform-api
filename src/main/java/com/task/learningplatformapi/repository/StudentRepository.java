package com.task.learningplatformapi.repository;

import com.task.learningplatformapi.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CustomCrud<Student, Long> {
}
