package com.admin.dao;

import com.admin.dto.CollegeDto;
import java.util.List;

public interface StatusableDao<T> extends GenericDao<T> {

    List<T> findAllByNotInStatus(List<String> statusNames);

    List<T> findAllByInStatus(List<String> statusNames);

    public T getByStatusDesc(String statusDesc);

    public List<T> findAllExceptBlockedAndDeleted();

    @Override
    public Long getTotalCount();

    @Override
    public T getById(Long id);

    @Override
    public List<T> findAll();

    @Override
    List<T> findAllByCollegeId(CollegeDto collegeDto); 
}
