/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.CollegeDto;
import com.payrollSystem.entity.common.College;

/**
 *
 * @author sanjeena
 */
public class CollegeMapper {
        public static CollegeDto convertToDto(College college) {
        CollegeDto collegeDto = new CollegeDto();
        collegeDto.setName(college.getName());
        collegeDto.setAddress(college.getAddress());
        collegeDto.setEstablishedYear(college.getEstablishedYear());
        collegeDto.setCollegeLogoPath(college.getCollegeLogoPath());
        collegeDto.setCode(college.getCode());
        collegeDto.setEmail(college.getEmail());
        collegeDto.setContact(college.getContact());
        return collegeDto;
    }
}
