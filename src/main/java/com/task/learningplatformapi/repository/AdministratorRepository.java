package com.task.learningplatformapi.repository;

import com.task.learningplatformapi.entity.Administrator;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CustomCrud<Administrator, Long> {
}
