/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.abstracts.AbstractAdminEmployeeParentDto;
import static com.admin.mapper.AbstractAdminMapper.convertCommonAdminParameters;
import com.payrollSystem.entity.abstracts.AbstractAdminEmployeeParent;

/**
 *
 * @author sanjeena
 */
public abstract class AbstractAdminEmployeeParentMapper extends AbstractAdminMapper{
    protected static <T extends AbstractAdminEmployeeParentDto, K extends AbstractAdminEmployeeParent> void convertCommonAdminEmployeeParent(T abstractAdminEmployeeParentDto, K abstractAdminEmployeeParent) {
        abstractAdminEmployeeParentDto.setCollegeDto(CollegeMapper.convertToDto(abstractAdminEmployeeParent.getCollege()));
        convertCommonAdminParameters(abstractAdminEmployeeParentDto, abstractAdminEmployeeParent);
    } 
}
