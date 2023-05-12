package com.task.learningplatformapi.service;

import com.task.learningplatformapi.dto.LogDTO;

public interface LogService {

    LogDTO create(LogDTO dto);

    LogDTO update(LogDTO log);

    void delete(Long id);
}
