/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.GenderDto;
import com.payrollSystem.entity.common.Gender;

/**
 *
 * @author user
 */
public class GenderMapper {
    public static GenderDto convertToDto(Gender gender) {
        GenderDto genderDto = new GenderDto();
        genderDto.setName(gender.getName());
        genderDto.setId(gender.getId());
        return genderDto;
    }
}
