package com.admin.mapper;

import com.admin.dto.StatusDto;
import com.payrollSystem.entity.common.Status;
import java.util.ArrayList;
import java.util.List;

public class StatusMapper {

    public static StatusDto convertToDto(Status status) {
        StatusDto statusDto = new StatusDto();
        statusDto.setName(status.getName());
        statusDto.setStatusDesc(status.getStatusDesc());
        statusDto.setStatusId(status.getStatusId());
        statusDto.setIcon(status.getIcon());
        return statusDto;
    }

    public static Status convertToStatus(StatusDto statusDto) {
        Status status = new Status();
        status.setName(statusDto.getName());
        status.setStatusDesc(statusDto.getStatusDesc());
        status.setStatusId(statusDto.getStatusId());
        return status;
    }

    public static List<StatusDto> convertToDtos(List<Status> statuses) {
        List<StatusDto> statusDtos = new ArrayList<>();
        for (Status status : statuses) {
            statusDtos.add(convertToDto(status));
        }
        return statusDtos;
    }
}
