package com.task.learningplatformapi.controller;

import com.task.learningplatformapi.dto.NewEnrollmentDTO;
import com.task.learningplatformapi.dto.StudentDTO;
import com.task.learningplatformapi.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(path = "/enrollments")
public class EnrollmentController {

    private EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody NewEnrollmentDTO enrollment) {
        service.enroll(enrollment);
        return ResponseEntity.ok().build();
    }

}
