package com.task.learningplatformapi.service.impl;

import com.task.learningplatformapi.dto.LogDTO;
import com.task.learningplatformapi.entity.Log;
import com.task.learningplatformapi.exception.MissingIdToPersistEntityException;
import com.task.learningplatformapi.repository.LogRepository;
import com.task.learningplatformapi.service.LogService;
import com.task.learningplatformapi.util.MapperUtil;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository repository;
    private final MapperUtil mapperUtil;

    public LogServiceImpl(LogRepository repository, MapperUtil mapperUtil) {
        this.repository = repository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public LogDTO create(LogDTO dto) {
        dto.setId(null);
        validateCreateData(dto);
        Log saved = repository.save(mapperUtil.map(dto, Log.class));
        return mapperUtil.map(saved, LogDTO.class);
    }

    @Override
    public LogDTO update(LogDTO dto) {
        validateUpdateData(dto);
        Log updated = repository.save(mapperUtil.map(dto, Log.class));
        return mapperUtil.map(updated, LogDTO.class);
    }

    @Override
    public void delete(Long id) {
        repository.delete(new Log(id));
    }

    private void validateCreateData(LogDTO dto) {
        // Validate the enrollment id exists
        if (dto.getEnrollment().getId() == null) {
            throw new MissingIdToPersistEntityException("Missing enrollment id to create the log!");
        }
    }
    private void validateUpdateData(LogDTO dto) {
        // Validate the id exists
        if (dto.getId() == null) {
            throw new MissingIdToPersistEntityException("Missing id to update the log!");
        }
    }
}
