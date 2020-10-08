/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.DepartmentDao;
import com.admin.dto.DepartmentDto;
import com.payrollSystem.entity.common.Department;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author sanjeena
 */
@Stateless
public class DepartmentDaoImpl extends StatusableDaoImpl<Department> implements DepartmentDao {

    public DepartmentDaoImpl() {
        super(Department.class);
    }
  @Override
    public boolean checkIfDepartmentNameAlreadyExists(DepartmentDto departmentDto) {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(s.id) FROM Department s WHERE s.createdByAdmin.college.id=:collegeId AND s.name=:departmentName AND s.status.statusDesc NOT IN (:deletedStatusList)");
        if (departmentDto.getId() != null) {
            stringBuilder.append("and s.id<>:departmentId");
        }
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("collegeId", departmentDto.getCreatedByAdminDto().getCollegeDto().getId());
        query.setParameter("departmentName", departmentDto.getName());
        query.setParameter("deletedStatusList", StatusConstants.deleteStatusList());
        if (departmentDto.getId() != null) {
            query.setParameter("departmentId", departmentDto.getId());
        }
        return (Long) query.getSingleResult() > 0;
    }
@Override
    public boolean checkIfDepartmentCodeAlreadyExists(DepartmentDto departmentDto) {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(s.id) FROM Department s WHERE s.createdByAdmin.college.id=:collegeId AND s.code=:departmentCode AND s.status.statusDesc NOT IN (:deletedStatusList)");
        if (departmentDto.getId() != null) {
            stringBuilder.append("and s.id<>:departmentId");
        }
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("collegeId", departmentDto.getCreatedByAdminDto().getCollegeDto().getId());
        query.setParameter("deletedStatusList", StatusConstants.deleteStatusList());
        query.setParameter("departmentCode", departmentDto.getCode());
        if (departmentDto.getId() != null) {
            query.setParameter("departmentId", departmentDto.getId());
        }
        return (Long) query.getSingleResult() > 0;
    }

}
