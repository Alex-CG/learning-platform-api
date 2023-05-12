package com.task.learningplatformapi.service.impl;

import com.task.learningplatformapi.dto.StudentDTO;
import com.task.learningplatformapi.entity.Student;
import com.task.learningplatformapi.exception.StudentUnderAllowedAgeException;
import com.task.learningplatformapi.repository.StudentRepository;
import com.task.learningplatformapi.service.StudentService;
import com.task.learningplatformapi.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final MapperUtil mapperUtil;

    private static final Integer MIN_STUDENT_AGE = 16;

    public StudentServiceImpl(StudentRepository repository, MapperUtil mapperUtil) {
        this.repository = repository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public StudentDTO create(StudentDTO dto) {
        dto.setId(null);
        validateCreateData(dto);
        Student saved = repository.save(mapperUtil.map(dto, Student.class));
        return mapperUtil.map(saved, StudentDTO.class);
    }

    private void validateCreateData(StudentDTO dto) {
        // Validate a student is not under allowed age
        LocalDate today = LocalDate.now();
        Period age = Period.between(dto.getDob(), today);
        if (age.getYears() < MIN_STUDENT_AGE) {
            throw new StudentUnderAllowedAgeException(
                    String.format("Student should be at least %s years old!", MIN_STUDENT_AGE));
        }
    }

}
