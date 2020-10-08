/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.dto.AdminDto;
import com.payrollSystem.entity.common.Admin;
import javax.ejb.Local;

/**
 *
 * @author sanjeena
 */
@Local
public interface AdminDao extends StatusableDao<Admin> {
      boolean checkIfAdminNameAlreadyExists(AdminDto adminDto);

    boolean checkIfAttendanceCodeAlreadyExists(AdminDto adminDto);
}
