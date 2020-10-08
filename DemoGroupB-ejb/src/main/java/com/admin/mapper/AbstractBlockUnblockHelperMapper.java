/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.abstracts.AbstractBlockUnblockHelperDto;
import com.payrollSystem.entity.abstracts.AbstractBlockUnblockHelper;

/**
 *
 * @author sanjeena
 */
public abstract class AbstractBlockUnblockHelperMapper {
     protected static <T extends AbstractBlockUnblockHelperDto, K extends AbstractBlockUnblockHelper> void convertCommonBlockUnblockParameters(T abstractBlockUnblockHelperDto, K abstractBlockUnblockHelper) {
         
              if (abstractBlockUnblockHelper.getCreatedByAdmin() != null) {
            abstractBlockUnblockHelperDto.getCreatedByAdminDto().setUsername(abstractBlockUnblockHelper.getCreatedByAdmin().getUsername());
            abstractBlockUnblockHelperDto.setCreatedDate(abstractBlockUnblockHelper.getCreatedDate());
        }
              abstractBlockUnblockHelperDto.setId(abstractBlockUnblockHelper.getId());
          abstractBlockUnblockHelperDto.setLastBlockedDate(abstractBlockUnblockHelper.getLastBlockedDate());
        abstractBlockUnblockHelperDto.setStatusDto(StatusMapper.convertToDto(abstractBlockUnblockHelper.getStatus()));
        if (abstractBlockUnblockHelper.getUpdatedByAdmin() != null) {
            abstractBlockUnblockHelperDto.setLastUpdatedDate(abstractBlockUnblockHelper.getLastUpdatedDate());
            abstractBlockUnblockHelperDto.getUpdatedByAdminDto().setUsername(abstractBlockUnblockHelper.getUpdatedByAdmin().getUsername());
        }
        if (abstractBlockUnblockHelper.getDeletedByAdmin() != null) {
            abstractBlockUnblockHelperDto.setDeletedDate(abstractBlockUnblockHelper.getDeletedDate());
            abstractBlockUnblockHelperDto.getDeletedByAdminDto().setUsername(abstractBlockUnblockHelper.getDeletedByAdmin().getUsername());
            abstractBlockUnblockHelperDto.setDeletedReason(abstractBlockUnblockHelper.getDeletedReason());
        }

    }
     }

