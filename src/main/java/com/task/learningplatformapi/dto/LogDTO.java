package com.task.learningplatformapi.dto;

import com.task.learningplatformapi.enums.TaskCategory;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LogDTO {

    private Long id;

    @NotNull
    private EnrollmentDTO enrollment;

    @NotBlank
    private TaskCategory taskCategory;

    @NotBlank
    private String taskDescription;

    @NotBlank
    private String timeSpent;
}

