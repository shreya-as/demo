/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.DesignationDao;
import com.admin.dto.DesignationDto;
import com.payrollSystem.entity.common.Designation;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author sanjeena
 */
@Stateless
public class DesignationDaoImpl extends StatusableDaoImpl<Designation> implements DesignationDao {

    public DesignationDaoImpl() {
        super(Designation.class);
    }
      @Override
    public boolean checkIfDesignationNameAlreadyExists(DesignationDto designationDto) {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(s.id) FROM Designation s WHERE s.createdByAdmin.college.id=:collegeId AND s.name=:designationName AND s.status.statusDesc NOT IN (:deletedStatusList)");
        if (designationDto.getId() != null) {
            stringBuilder.append("and s.id<>:designationId");
        }
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("collegeId", designationDto.getCreatedByAdminDto().getCollegeDto().getId());
        query.setParameter("designationName", designationDto.getName());
        query.setParameter("deletedStatusList", StatusConstants.deleteStatusList());
        if (designationDto.getId() != null) {
            query.setParameter("designationId", designationDto.getId());
        }
        return (Long) query.getSingleResult() > 0;
    }
@Override
    public boolean checkIfDesignationCodeAlreadyExists(DesignationDto designationDto) {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(s.id) FROM Designation s WHERE s.createdByAdmin.college.id=:collegeId AND s.code=:designationCode AND s.status.statusDesc NOT IN (:deletedStatusList)");
        if (designationDto.getId() != null) {
            stringBuilder.append("and s.id<>:designationId");
        }
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("collegeId", designationDto.getCreatedByAdminDto().getCollegeDto().getId());
        query.setParameter("deletedStatusList", StatusConstants.deleteStatusList());
        query.setParameter("designationCode", designationDto.getCode());
        if (designationDto.getId() != null) {
            query.setParameter("designationId", designationDto.getId());
        }
        return (Long) query.getSingleResult() > 0;
    }
}

