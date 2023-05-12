package com.task.learningplatformapi.repository;

import com.task.learningplatformapi.model.Administrator;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CustomCrud<Administrator, Long> {
}
