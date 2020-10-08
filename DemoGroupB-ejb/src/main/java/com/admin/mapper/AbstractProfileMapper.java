package com.admin.mapper;

import com.admin.dto.abstracts.AbstractProfileDto;
import com.payrollSystem.entity.abstracts.AbstractProfile;

/**
 *
 * @author paawan.bhatt
 */
public abstract class AbstractProfileMapper {

    protected static <T extends AbstractProfileDto, K extends AbstractProfile> void convertCommonParameters(T abstractProfileDto, K abstractProfile) {
        if (abstractProfile.getCreatedByAdmin() != null) {
            abstractProfileDto.getCreatedByAdminDto().setUsername(abstractProfile.getCreatedByAdmin().getUsername());
            abstractProfileDto.setCreatedDate(abstractProfile.getCreatedDate());
        }

        abstractProfileDto.setDescription(abstractProfile.getDescription());
        abstractProfileDto.setId(abstractProfile.getId());
        abstractProfileDto.setName(abstractProfile.getName());
        abstractProfileDto.setStatusDto(StatusMapper.convertToDto(abstractProfile.getStatus()));
        if (abstractProfile.getUpdatedByAdmin() != null) {
            abstractProfileDto.setLastUpdatedDate(abstractProfile.getLastUpdatedDate());
            abstractProfileDto.getUpdatedByAdminDto().setUsername(abstractProfile.getUpdatedByAdmin().getUsername());
        }
        if (abstractProfile.getDeletedByAdmin() != null) {
            abstractProfileDto.setDeletedDate(abstractProfile.getDeletedDate());
            abstractProfileDto.getDeletedByAdminDto().setUsername(abstractProfile.getDeletedByAdmin().getUsername());
            abstractProfileDto.setDeletedReason(abstractProfile.getDeletedReason());
        }

    }
}
