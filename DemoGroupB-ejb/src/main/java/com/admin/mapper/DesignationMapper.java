/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.DesignationDto;
import com.payrollSystem.entity.common.Designation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sanjeena
 */
public class DesignationMapper extends AbstractCodeMapper{
    
    public static DesignationDto convertToDto(Designation designation) {
        DesignationDto designationDto = new DesignationDto();
          designationDto.setBasicSalary(designation.getBasicSalary());
          designationDto.setGrade(designation.getGrade());
        convertCommon(designationDto, designation);
        return designationDto;
    }

    public static List<DesignationDto> convertToDtos(List<Designation> designations) {
        List<DesignationDto> designationDtos = new ArrayList<>();
        for (Designation designation : designations) {
            designationDtos.add(convertToDto(designation));
        }
        return designationDtos;
    }

    public static DesignationDto convertToDtoForDropDown(Designation designation) {
        DesignationDto designationDto = new DesignationDto();
        designationDto.setCode(designation.getCode());
        designationDto.setId(designation.getId());
        designationDto.setName(designation.getName());
        return designationDto;
    }
    
    public static List<DesignationDto> convertToDtosForDropDown(List<Designation> designations) {
        List<DesignationDto> designationDtos = new ArrayList<>();
        for (Designation designation : designations) {
            designationDtos.add(convertToDtoForDropDown(designation));
        }
        return designationDtos;
    }

}
