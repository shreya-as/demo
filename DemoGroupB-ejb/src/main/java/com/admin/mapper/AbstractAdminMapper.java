/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.abstracts.AbstractAdminDto;
import static com.admin.mapper.AbstractUserMapper.convertCommonUserParameters;
import com.payrollSystem.entity.abstracts.AbstractAdmin;

/**
 *
 * @author sanjeena
 */
public abstract class AbstractAdminMapper extends AbstractUserMapper{
     protected static <T extends AbstractAdminDto, K extends AbstractAdmin> void convertCommonAdminParameters(T abstractAdminDto, K abstractAdmin) {
            abstractAdminDto.setFirstName(abstractAdmin.getFirstName());
             abstractAdminDto.setMiddleName(abstractAdmin.getMiddleName());
              abstractAdminDto.setLastName(abstractAdmin.getLastName());
              abstractAdminDto.setEmail(abstractAdmin.getEmail());
              abstractAdminDto.setMobileNumber(abstractAdmin.getMobileNumber());
              abstractAdminDto.setTemporaryAddress(abstractAdmin.getTemporaryAddress());
              abstractAdminDto.setPermanentAddress(abstractAdmin.getPermanentAddress());
             convertCommonUserParameters(abstractAdminDto, abstractAdmin);
}
}
