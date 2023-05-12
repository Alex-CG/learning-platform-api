package com.task.learningplatformapi.service.impl;

import com.task.learningplatformapi.dto.NewEnrollmentDTO;
import com.task.learningplatformapi.entity.Course;
import com.task.learningplatformapi.entity.Enrollment;
import com.task.learningplatformapi.entity.Student;
import com.task.learningplatformapi.exception.MaxCoursesPerEnrollmentExceededException;
import com.task.learningplatformapi.repository.EnrollmentRepository;
import com.task.learningplatformapi.service.EnrollmentService;
import com.task.learningplatformapi.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository repository;
    private final MapperUtil mapperUtil;

    private static final Integer MAX_COURSES_PER_ENROLLMENT = 3;

    public EnrollmentServiceImpl(EnrollmentRepository repository, MapperUtil mapperUtil) {
        this.repository = repository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public void enroll(NewEnrollmentDTO dto) {
        validateCreateData(dto);
        List<Enrollment> enrollments = dto.getCourses().stream()
                .map(obj -> mapperUtil.map(obj, Course.class))
                .map(course -> new Enrollment(new Student(), course)) // TODO: get user from session
                .toList();
        repository.saveAll(enrollments);
    }

    private void validateCreateData(NewEnrollmentDTO dto) {
        // Validate a student is not under allowed age
        if (dto.getCourses().size() > MAX_COURSES_PER_ENROLLMENT) {
            throw new MaxCoursesPerEnrollmentExceededException(
                    String.format("Max number of courses (%s) per enrollment exceeded!", MAX_COURSES_PER_ENROLLMENT));
        }
    }

}
