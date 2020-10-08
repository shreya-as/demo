package com.admin.dao;

import com.admin.dto.StatusDto;
import com.payrollSystem.entity.common.Status;
import java.util.List;
import javax.ejb.Local;

@Local
public interface StatusDao extends GenericDao<Status>{

    public Status getByDesc(String name);

    List<String> getAllDesc();

    List<StatusDto> getAllForUserSearch();
}
