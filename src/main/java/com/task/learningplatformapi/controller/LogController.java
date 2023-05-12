package com.task.learningplatformapi.controller;

import com.task.learningplatformapi.dto.LogDTO;
import com.task.learningplatformapi.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping(path = "/log")
public class LogController {

    private final LogService service;

    public LogController(LogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LogDTO> create(@RequestBody LogDTO log) {
        return ResponseEntity.ok(service.create(log));
    }

    @PutMapping
    public ResponseEntity<LogDTO> update(@RequestBody LogDTO log) {
        return ResponseEntity.ok(service.update(log));
    }
}
