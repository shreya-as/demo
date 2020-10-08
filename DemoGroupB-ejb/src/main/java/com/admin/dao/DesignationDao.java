/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.dto.DesignationDto;
import com.payrollSystem.entity.common.Designation;
import javax.ejb.Local;

/**
 *
 * @author sanjeena
 */
@Local
public interface DesignationDao extends StatusableDao<Designation> {
boolean checkIfDesignationNameAlreadyExists(DesignationDto designationDto);

    boolean checkIfDesignationCodeAlreadyExists(DesignationDto designationDto);
}
