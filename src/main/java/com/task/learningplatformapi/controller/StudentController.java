package com.task.learningplatformapi.controller;

import com.task.learningplatformapi.dto.StudentDTO;
import com.task.learningplatformapi.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO student) {
        return ResponseEntity.ok(service.create(student));
    }

}
