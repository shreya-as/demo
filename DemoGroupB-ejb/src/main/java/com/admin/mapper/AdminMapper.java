/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.AdminDto;
import static com.admin.mapper.AbstractAdminEmployeeParentMapper.convertCommonAdminEmployeeParent;
import com.payrollSystem.entity.common.Admin;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sanjeena
 */
public class AdminMapper extends AbstractAdminEmployeeParentMapper{
     public static AdminDto convertToDto(Admin admin) {
        AdminDto adminDto = new AdminDto();
        adminDto.setIsCollegeSuperAdmin(admin.getIsCollegeSuperAdmin());
        adminDto.setIsCoordinator(admin.getIsCoordinator());
        adminDto.setIsSalaryMonthly(admin.getIsSalaryMonthly());
        adminDto.setIsAttendanceCompulsory(admin.getIsAttendanceCompulsory());
        adminDto.setJoinedDate(admin.getJoinedDate());
        adminDto.setIsDisabled(admin.getIsDisabled());
        adminDto.setIsFullTimer(admin.getIsFullTimer());
        adminDto.setIsHod(admin.getIsHod());
        adminDto.setIsSupervisor(admin.getIsSupervisor());
        adminDto.setMaritalStatus(admin.getMaritalStatus());
        adminDto.setAttendanceCode(admin.getAttendanceCode());
        adminDto.setEmployeeCode(admin.getEmployeeCode());
        adminDto.setDateOfBirth(admin.getDateOfBirth());
        adminDto.setCategory(admin.getCategory());
        adminDto.setPanNumber(admin.getPanNumber());
        adminDto.setCitizenshipNumber(admin.getCitizenshipNumber());
        adminDto.setFatherName(admin.getFatherName());
        adminDto.setMotherName(admin.getMotherName());
        adminDto.setSpouseName(admin.getSpouseName());
        adminDto.setGrandfatherName(admin.getGrandFatherName());
        adminDto.setHomeTelephoneNumber(admin.getHomeTelephoneNumber());
        adminDto.setBloodgroup(admin.getBloodgroup());
        adminDto.setDateOfConfirmation(admin.getDateOfConfirmation());
        adminDto.setRemarks(admin.getRemarks());
        adminDto.setDesignationDto(DesignationMapper.convertToDto(admin.getDesignation()));
        adminDto.setDepartmentDto(DepartmentMapper.convertToDto(admin.getDepartment()));
        adminDto.setGenderDto(GenderMapper.convertToDto(admin.getGender()));
        convertCommonAdminEmployeeParent(adminDto, admin);
        return adminDto;
    }

    public static List<AdminDto> convertToDtos(List<Admin> admins) {
        List<AdminDto> adminDtos = new ArrayList<>();
        for (Admin admin : admins) {
            adminDtos.add(convertToDto(admin));
        }
        return adminDtos;
    }
}
