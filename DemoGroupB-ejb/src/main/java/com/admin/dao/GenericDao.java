package com.admin.dao;

import com.admin.dto.CollegeDto;
import java.util.List;

public interface GenericDao<T> {

    Boolean save(T entity);

    Boolean modify(T entity);

    T getById(Long id);

    List<T> findAll();

    Long totalCount();

    public Long getTotalCount();

    List<T> findAllByCollegeId(CollegeDto collegeDto);   
}
