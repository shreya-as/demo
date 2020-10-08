/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.service;

import com.admin.dto.CollegeDto;
import com.admin.dto.DesignationDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sanjeena
 */
@Local
public interface DesignationService {

   
    public boolean save(DesignationDto designationdto);

    boolean delete(DesignationDto designationDto);
    
    boolean checkIfDesignationNameAlreadyExists(DesignationDto designationDto);

    boolean checkIfDesignationCodeAlreadyExists(DesignationDto designationDto);
    
    boolean update(DesignationDto designationDto);
    
    List<DesignationDto> findByCollegeId(CollegeDto collegeDto);
    
    List<DesignationDto> findByCollegeIdForDropDown(CollegeDto collegeDto);
}
