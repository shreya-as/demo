/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.designation;


import com.admin.dto.AdminDto;
import com.admin.dto.CollegeDto;
import com.admin.dto.DesignationDto;
import com.admin.service.DesignationService;
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
 * @author user
 */
@Getter
@Setter
@ManagedBean
@RequestScoped
public class DesignationBeanJsf {

    @ManagedProperty(value = "#{designationDataModelJsf}")
    private DesignationDataModelJsf designationDataModelJsf;

    @EJB
    private DesignationService designationService;

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
        return "designation.xhtml?faces-redirect=true";
    }

    public String initCreate() {
        designationDataModelJsf.setDesignationDto(new DesignationDto());
        designationDataModelJsf.setCreateEditPanel(true);
        return returnToPage();
    }

    public String saveUpdate() {
        designationDataModelJsf.getDesignationDto().setUpdatedByAdminDto(adminDto);
        designationDataModelJsf.getDesignationDto().setCreatedByAdminDto(adminDto);
        
        if (designationService.checkIfDesignationNameAlreadyExists(designationDataModelJsf.getDesignationDto())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Designation Name Already Exists", null));
            return returnToPage();
        }
        if (designationService.checkIfDesignationCodeAlreadyExists(designationDataModelJsf.getDesignationDto())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Designation Code Already Exists", null));
            return returnToPage();
        }

        if (designationDataModelJsf.getDesignationDto().getId() == null) {
            return save();
        } else {
            return update();
        }
    }

    private String update() {
        boolean success = designationService.update(designationDataModelJsf.getDesignationDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfully", null));
        }
        return navigateToPage();
    }

    private String save() {
        boolean response = designationService.save(designationDataModelJsf.getDesignationDto());
        if (response) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Saved", null));
        }
        return navigateToPage();
    }

    public String navigateToPage() {
        Utility.removeSessionBeanJSFDataModelObject("designationDataModelJsf");
        designationDataModelJsf = (DesignationDataModelJsf) Utility.getSessionObject("designationDataModelJsf");
        designationDataModelJsf.setDesignationDtos(designationService.findByCollegeId(collegeDto));
        return returnToPage();
    }

    public String initEdit() {
        designationDataModelJsf.setCreateEditPanel(true);
        return returnToPage();
    }

    public String delete() {
        designationDataModelJsf.getDesignationDto().setDeletedByAdminDto(adminDto);
        
        boolean success = designationService.delete(designationDataModelJsf.getDesignationDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfully", null));
        }
        return navigateToPage();
    }

}
