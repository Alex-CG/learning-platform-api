package com.task.learningplatformapi.service.impl;

import com.task.learningplatformapi.dto.CourseDTO;
import com.task.learningplatformapi.dto.StudentDTO;
import com.task.learningplatformapi.entity.Course;
import com.task.learningplatformapi.exception.MissingIdToUpdateEntityException;
import com.task.learningplatformapi.exception.StudentUnderAllowedAgeException;
import com.task.learningplatformapi.repository.CourseRepository;
import com.task.learningplatformapi.service.CourseService;
import com.task.learningplatformapi.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository repository, MapperUtil mapperUtil) {
        this.repository = repository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CourseDTO create(CourseDTO dto) {
        dto.setId(null);
        Course saved = repository.save(mapperUtil.map(dto, Course.class));
        return mapperUtil.map(saved, CourseDTO.class);
    }

    @Override
    public CourseDTO update(CourseDTO dto) {
        validateUpdateData(dto);
        Course saved = repository.save(mapperUtil.map(dto, Course.class));
        return mapperUtil.map(saved, CourseDTO.class);
    }

    private void validateUpdateData(CourseDTO dto) {
        // Validate the id exists
        if (dto.getId() == null) {
            throw new MissingIdToUpdateEntityException("Missing course id to perform the update!");
        }
    }
}
