package com.task.learningplatformapi.controller;

import com.task.learningplatformapi.dto.CourseDTO;
import com.task.learningplatformapi.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(path = "/course")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO course) {
        return ResponseEntity.ok(service.create(course));
    }

    @PutMapping
    public ResponseEntity<CourseDTO> update(@RequestBody CourseDTO course) {
        return ResponseEntity.ok(service.update(course));
    }
}
