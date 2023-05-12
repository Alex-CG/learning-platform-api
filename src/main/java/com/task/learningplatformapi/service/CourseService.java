package com.task.learningplatformapi.service;

import com.task.learningplatformapi.dto.CourseDTO;

public interface CourseService {

    CourseDTO create(CourseDTO dto);

    CourseDTO update(CourseDTO dto);

}
