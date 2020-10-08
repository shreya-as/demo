/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.serviceImpl;

import com.admin.constant.BranchConstants;
import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dao.BranchDao;
import com.admin.dao.DepartmentDao;
import com.admin.dao.StatusDao;
import com.admin.dto.CollegeDto;
import com.admin.dto.DepartmentDto;
import com.admin.mapper.DepartmentMapper;
import com.payrollSystem.entity.common.Department;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.admin.service.DepartmentService;
import java.util.List;

/**
 *
 * @author sanjeena
 */
@Stateless
public class DepartmentServiceImpl implements DepartmentService {

    @EJB
    private DepartmentDao departmentDao;

    @EJB
    private StatusDao statusDao;

    @EJB
    private BranchDao branchDao;

    @EJB
    private AdminDao adminDao;

    @Override
    public boolean save(DepartmentDto departmentDto) {
        return departmentDao.save(convertToDepartment(departmentDto));
    }

    private Department convertToDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setCreatedDate(new Date());
        department.setCreatedByAdmin(adminDao.getById(departmentDto.getCreatedByAdminDto().getId()));
        department.setBranch(branchDao.getByBranchName(BranchConstants.SUNRISE_KATHMANDU.getName()));
        department.setStatus(statusDao.getByDesc(StatusConstants.CREATE_APPROVE.getName()));
        setCreateEditCommonParameters(department, departmentDto);
        return department;
    }

    private void setCreateEditCommonParameters(Department department, DepartmentDto departmentDto) {
        department.setDescription(departmentDto.getDescription());
        department.setName(departmentDto.getName());
        department.setCode(departmentDto.getCode());
    }

    @Override
    public boolean delete(DepartmentDto departmentDto) {
        Department department = departmentDao.getById(departmentDto.getId());
        department.setDeletedDate(new Date());
        department.setDeletedReason(departmentDto.getDeletedReason());
        department.setDeletedByAdmin(adminDao.getById(departmentDto.getDeletedByAdminDto().getId()));
        department.setStatus(statusDao.getByDesc(StatusConstants.DELETED_APPROVE.getName()));
        return departmentDao.modify(department);
    }

    public boolean update(DepartmentDto departmentDto) {
        Department department = departmentDao.getById(departmentDto.getId());
        department.setLastUpdatedDate(new Date());
        department.setUpdatedByAdmin(adminDao.getById(departmentDto.getUpdatedByAdminDto().getId()));
        department.setStatus(statusDao.getByDesc(StatusConstants.EDIT_APPROVE.getName()));
        setCreateEditCommonParameters(department, departmentDto);
        return departmentDao.modify(department);
    }

    @Override
    public boolean checkIfDepartmentNameAlreadyExists(DepartmentDto departmentDto) {
        return departmentDao.checkIfDepartmentNameAlreadyExists(departmentDto);
    }

    @Override
    public boolean checkIfDepartmentCodeAlreadyExists(DepartmentDto departmentDto) {
        return departmentDao.checkIfDepartmentCodeAlreadyExists(departmentDto);
    }
     @Override
    public List<DepartmentDto> findByCollegeId(CollegeDto collegeDto) {
        return DepartmentMapper.convertToDtos(departmentDao.findAllByCollegeId(collegeDto));
    }
        @Override
    public List<DepartmentDto> findByCollegeIdForDropDown(CollegeDto collegeDto) {
        return DepartmentMapper.convertToDtosForDropDown(departmentDao.findAllByCollegeId(collegeDto));
    }
}
