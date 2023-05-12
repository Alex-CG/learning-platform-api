package com.task.learningplatformapi.repository;

import com.task.learningplatformapi.model.Log;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CustomCrud<Log, Long> {
}
