package com.task.learningplatformapi.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    private final ModelMapper modelMapper;

    public MapperUtil() {
        this.modelMapper = new ModelMapper();
    }

    public <S, D> D map(S source, Class<D> targetType) {
        return modelMapper.map(source, targetType);
    }
}

