package com.task.learningplatformapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CourseDTO {

    private Long id;

    @NotBlank
    private String name;

    private String description;
}
