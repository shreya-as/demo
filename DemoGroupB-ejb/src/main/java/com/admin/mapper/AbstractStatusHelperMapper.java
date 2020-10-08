/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.abstracts.AbstractStatusHelperDto;
import com.payrollSystem.entity.abstracts.AbstractStatusHelper;

/**
 *
 * @author user
 */
public abstract class AbstractStatusHelperMapper {
        protected static <T extends AbstractStatusHelperDto, K extends AbstractStatusHelper> void convertCommonStatusParameters(T abstractStatusHelperDto, K abstractStatusHelper) {
        if (abstractStatusHelper.getCreatedByAdmin() != null) {
            abstractStatusHelperDto.getCreatedByAdminDto().setUsername(abstractStatusHelper.getCreatedByAdmin().getUsername());
            abstractStatusHelperDto.setCreatedDate(abstractStatusHelper.getCreatedDate());
        }

       
        abstractStatusHelperDto.setId(abstractStatusHelper.getId());
        abstractStatusHelperDto.setStatusDto(StatusMapper.convertToDto(abstractStatusHelper.getStatus()));
        if (abstractStatusHelper.getUpdatedByAdmin() != null) {
            abstractStatusHelperDto.setLastUpdatedDate(abstractStatusHelper.getLastUpdatedDate());
            abstractStatusHelperDto.getUpdatedByAdminDto().setUsername(abstractStatusHelper.getUpdatedByAdmin().getUsername());
        }
        if (abstractStatusHelper.getDeletedByAdmin() != null) {
            abstractStatusHelperDto.setDeletedDate(abstractStatusHelper.getDeletedDate());
            abstractStatusHelperDto.getDeletedByAdminDto().setUsername(abstractStatusHelper.getDeletedByAdmin().getUsername());
            abstractStatusHelperDto.setDeletedReason(abstractStatusHelper.getDeletedReason());
        }

    }
}
