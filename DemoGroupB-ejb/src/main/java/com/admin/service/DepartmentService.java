/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.service;

import com.admin.dto.CollegeDto;
import com.admin.dto.DepartmentDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sanjeena
 */
@Local
public interface DepartmentService {

    public boolean save(DepartmentDto departmentdto);

    boolean delete(DepartmentDto departmentDto);
    
    boolean checkIfDepartmentNameAlreadyExists(DepartmentDto departmentDto);

    boolean checkIfDepartmentCodeAlreadyExists(DepartmentDto departmentDto);
    
    boolean update(DepartmentDto departmentDto);
    
    List<DepartmentDto> findByCollegeId(CollegeDto collegeDto);
    
      List<DepartmentDto> findByCollegeIdForDropDown(CollegeDto collegeDto);

}
