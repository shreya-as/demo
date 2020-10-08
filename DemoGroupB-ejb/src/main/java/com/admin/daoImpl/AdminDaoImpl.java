/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dto.AdminDto;
import com.payrollSystem.entity.common.Admin;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author sanjeena
 */
@Stateless
public class AdminDaoImpl extends StatusableDaoImpl<Admin> implements AdminDao {

    public AdminDaoImpl() {
        super(Admin.class);
    }

    @Override
    public boolean checkIfAdminNameAlreadyExists(AdminDto adminDto) {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(s.id) FROM Admin s WHERE s.username=:userName AND s.status.statusDesc NOT IN (:deletedStatusList) AND s.createdByAdmin.college.id=:collegeId");
        if (adminDto.getId() != null) {
            stringBuilder.append("and s.id<>:adminId");
        }
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("userName", adminDto.getEmail());
        query.setParameter("collegeId", adminDto.getCreatedByAdminDto().getCollegeDto().getId());
        query.setParameter("deletedStatusList", StatusConstants.deleteStatusList());
        if (adminDto.getId() != null) {
            query.setParameter("adminId", adminDto.getId());
        }
        return (Long) query.getSingleResult() > 0;
    }

    @Override
    public boolean checkIfAttendanceCodeAlreadyExists(AdminDto adminDto) {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(s.id) FROM Admin s WHERE s.attendanceCode=:attendanceCode AND s.status.statusDesc NOT IN (:deletedStatusList) AND s.createdByAdmin.college.id=:collegeId");
        if (adminDto.getId() != null) {
            stringBuilder.append("and s.id<>:adminId");
        }
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("deletedStatusList", StatusConstants.deleteStatusList());
        query.setParameter("collegeId", adminDto.getCreatedByAdminDto().getCollegeDto().getId());
        query.setParameter("attendanceCode", adminDto.getAttendanceCode());
        if (adminDto.getId() != null) {
            query.setParameter("adminId", adminDto.getId());
        }
        return (Long) query.getSingleResult() > 0;
    }
}
