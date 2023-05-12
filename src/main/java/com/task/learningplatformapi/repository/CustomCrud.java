package com.task.learningplatformapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomCrud<T, ID> extends CrudRepository<T, ID> {
}
