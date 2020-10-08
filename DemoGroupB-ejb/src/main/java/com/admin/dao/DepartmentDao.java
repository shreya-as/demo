/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.dto.DepartmentDto;
import com.payrollSystem.entity.common.Department;
import javax.ejb.Local;

/**
 *
 * @author sanjeena
 */
@Local
public interface DepartmentDao extends StatusableDao<Department> {

    boolean checkIfDepartmentNameAlreadyExists(DepartmentDto departmentDto);

    boolean checkIfDepartmentCodeAlreadyExists(DepartmentDto departmentDto);
}
