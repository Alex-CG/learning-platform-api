package com.task.learningplatformapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class NewEnrollmentDTO {

    @NotBlank
    private List<CourseDTO> courses;
}
