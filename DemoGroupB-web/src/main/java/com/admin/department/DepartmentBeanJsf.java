/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.department;

import com.admin.dto.AdminDto;
import com.admin.dto.CollegeDto;
import com.admin.dto.DepartmentDto;
import com.admin.service.DepartmentService;
import com.admin.util.Utility;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sanjeena
 */
@Getter
@Setter
@ManagedBean
@RequestScoped
public class DepartmentBeanJsf {

    @ManagedProperty(value = "#{departmentDataModelJsf}")
    private DepartmentDataModelJsf departmentDataModelJsf;

    @EJB
    private DepartmentService departmentService;

    private CollegeDto collegeDto;

    private AdminDto adminDto;

    @PostConstruct
    public void init() {
        collegeDto = new CollegeDto();
        collegeDto.setId(1l);

        adminDto = new AdminDto();
        adminDto.setId(1L);

        adminDto.setCollegeDto(collegeDto);
    }

    public String returnToPage() {
        return "department.xhtml?faces-redirect=true";
    }

    public String initCreate() {
        departmentDataModelJsf.setDepartmentDto(new DepartmentDto());
        departmentDataModelJsf.setCreateEditPanel(true);
        return returnToPage();
    }

    public String saveUpdate() {
        departmentDataModelJsf.getDepartmentDto().setUpdatedByAdminDto(adminDto);
        departmentDataModelJsf.getDepartmentDto().setCreatedByAdminDto(adminDto);

        if (departmentService.checkIfDepartmentNameAlreadyExists(departmentDataModelJsf.getDepartmentDto())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Department Name Already Exists", null));
            return returnToPage();
        }
        if (departmentService.checkIfDepartmentCodeAlreadyExists(departmentDataModelJsf.getDepartmentDto())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Department Code Already Exists", null));
            return returnToPage();
        }

        if (departmentDataModelJsf.getDepartmentDto().getId() == null) {
            return save();
        } else {
            return update();
        }
    }

    private String update() {
        boolean success = departmentService.update(departmentDataModelJsf.getDepartmentDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfully", null));
        }
        return navigateToPage();
    }

    private String save() {
        boolean response = departmentService.save(departmentDataModelJsf.getDepartmentDto());
        if (response) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Saved", null));
        }
        return navigateToPage();
    }

    public String navigateToPage() {
        Utility.removeSessionBeanJSFDataModelObject("departmentDataModelJsf");
        departmentDataModelJsf = (DepartmentDataModelJsf) Utility.getSessionObject("departmentDataModelJsf");
        departmentDataModelJsf.setDepartmentDtos(departmentService.findByCollegeId(collegeDto));
        return returnToPage();
    }

    public String initEdit() {
        departmentDataModelJsf.setCreateEditPanel(true);
        return returnToPage();
    }

    public String delete() {
        departmentDataModelJsf.getDepartmentDto().setDeletedByAdminDto(adminDto);

        boolean success = departmentService.delete(departmentDataModelJsf.getDepartmentDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfully", null));
        }
        return navigateToPage();
    }

}
