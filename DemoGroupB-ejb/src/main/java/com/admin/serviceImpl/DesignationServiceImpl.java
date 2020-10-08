/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.serviceImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dao.DesignationDao;
import com.admin.dao.StatusDao;
import com.admin.dto.CollegeDto;
import com.admin.dto.DesignationDto;
import com.admin.mapper.DesignationMapper;
import com.payrollSystem.entity.common.Designation;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.admin.service.DesignationService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sanjeena
 */
@Stateless
public class DesignationServiceImpl implements DesignationService {

    @EJB
    private DesignationDao designationDao;

    @EJB
    private StatusDao statusDao;

    @EJB
    private AdminDao adminDao;

    @Override
    public boolean save(DesignationDto designationDto) {
        return designationDao.save(convertToDesignation(designationDto));
    }

    private Designation convertToDesignation(DesignationDto designationDto) {
        Designation designation = new Designation();
        designation.setCreatedByAdmin(adminDao.getById(designationDto.getCreatedByAdminDto().getId()));
        designation.setCreatedDate(new Date());
        designation.setName(designationDto.getName());
        designation.setCode(designationDto.getCode());
        designation.setDescription(designationDto.getDescription());
        designation.setBasicSalary(designationDto.getBasicSalary());
        designation.setGrade(designationDto.getGrade());
        designation.setStatus(statusDao.getByDesc(StatusConstants.CREATE_APPROVE.getName()));
        return designation;
    }

    private void setCreateEditCommonParameters(Designation designation, DesignationDto designationDto) {
        designation.setDescription(designationDto.getDescription());
        designation.setName(designationDto.getName());
        designation.setCode(designationDto.getCode());
        designation.setBasicSalary(designationDto.getBasicSalary());
        designation.setGrade(designationDto.getGrade());
    }

    @Override
    public boolean delete(DesignationDto designationDto) {
        Designation designation = designationDao.getById(designationDto.getId());
        designation.setDeletedDate(new Date());
        designation.setDeletedReason(designationDto.getDeletedReason());
        designation.setDeletedByAdmin(adminDao.getById(designationDto.getDeletedByAdminDto().getId()));
        designation.setStatus(statusDao.getByDesc(StatusConstants.DELETED_APPROVE.getName()));
        return designationDao.modify(designation);
    }

    @Override
    public boolean update(DesignationDto designationDto) {
        Designation designation = designationDao.getById(designationDto.getId());
        designation.setLastUpdatedDate(new Date());
        designation.setUpdatedByAdmin(adminDao.getById(designationDto.getUpdatedByAdminDto().getId()));
        designation.setStatus(statusDao.getByDesc(StatusConstants.EDIT_APPROVE.getName()));
        setCreateEditCommonParameters(designation, designationDto);
        return designationDao.modify(designation);
    }

    @Override
    public boolean checkIfDesignationNameAlreadyExists(DesignationDto designationDto) {
        return designationDao.checkIfDesignationNameAlreadyExists(designationDto);
    }

    @Override
    public boolean checkIfDesignationCodeAlreadyExists(DesignationDto designationDto) {
        return designationDao.checkIfDesignationCodeAlreadyExists(designationDto);
    }

    @Override
    public List<DesignationDto> findByCollegeId(CollegeDto collegeDto) {
        return DesignationMapper.convertToDtos(designationDao.findAllByCollegeId(collegeDto));
    }

    @Override
    public List<DesignationDto> findByCollegeIdForDropDown(CollegeDto collegeDto) {
        return DesignationMapper.convertToDtosForDropDown(designationDao.findAllByCollegeId(collegeDto));
    }
}
