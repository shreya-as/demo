/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.issueRuleSetting;

import com.admin.constant.MemberTypeConstant;
import com.admin.constant.SemesterConstant;
import com.admin.dto.AdminDto;
import com.admin.dto.CollegeDto;
import com.admin.dto.IssueRuleSettingDto;
import com.admin.service.IssueRuleSettingService;
import com.admin.util.Utility;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.var;

/**
 *
 * @author fox
 */
@Getter
@Setter
@ManagedBean
@RequestScoped
public class IssueRuleSettingBeanJsf implements Serializable {

    @ManagedProperty(value = "#{issueRuleSettingDataModelJsf}")
    private IssueRuleSettingDataModelJsf issueRuleSettingDataModelJsf;
    @EJB
    private IssueRuleSettingService issueRuleSettingService;
    private AdminDto adminDto;
    private CollegeDto collegeDto;

    @PostConstruct
    public void init(){
        adminDto = new AdminDto();
        adminDto.setId(1L);
        collegeDto = new CollegeDto();
        collegeDto.setId(1l);
    }
     public String returnToPage() {
        return "issueRuleSetting.xhtml?faces-redirect=true";
    }

     public String initCreate(){
        issueRuleSettingDataModelJsf.setIssueRuleSettingDto(new IssueRuleSettingDto());
        loadDropdownMenus();
        issueRuleSettingDataModelJsf.setCreateEditPanel(true);
        return returnToPage();
    }


    public String save(){
        boolean response=false;
        issueRuleSettingDataModelJsf.getIssueRuleSettingDto().setCreatedByAdminDto(adminDto);
        if (!issueRuleSettingService.checkIfIssueSettingAlreadyExists(issueRuleSettingDataModelJsf.getIssueRuleSettingDto()))
             response = issueRuleSettingService.createIssueRuleSetting(issueRuleSettingDataModelJsf.getIssueRuleSettingDto());
        else
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,"Issue with same value already exists",null));

        if (response)
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,"Saved Successfully",null));
        return navigateToPage();
    }
    public String update(){
        boolean response = false;
        issueRuleSettingDataModelJsf.getIssueRuleSettingDto().setUpdatedByAdminDto(adminDto);
        if (!issueRuleSettingService.checkIfIssueSettingAlreadyExists(issueRuleSettingDataModelJsf.getIssueRuleSettingDto()))
             response = issueRuleSettingService.updateIssueRuleSetting(issueRuleSettingDataModelJsf.getIssueRuleSettingDto());
        else
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,"Issuer with same value already exists",null));

        if (response)
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,"Updated Successfully",null));
        return navigateToPage();
    }
    public String saveUpdate(){
        return issueRuleSettingDataModelJsf.getIssueRuleSettingDto().getId() == null ?save():update();
    }

    public String delete(){
        issueRuleSettingDataModelJsf.getIssueRuleSettingDto().setDeletedByAdminDto(adminDto);
        boolean response = issueRuleSettingService.deleteIssueRuleSetting(issueRuleSettingDataModelJsf.getIssueRuleSettingDto());
        if (response)
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,"Deleted Successfully",null));
        return navigateToPage();
    }

       public String navigateToPage(){
        Utility.removeSessionBeanJSFDataModelObject("issueRuleSettingDataModelJsf");
        issueRuleSettingDataModelJsf = (IssueRuleSettingDataModelJsf) Utility.getSessionObject("issueRuleSettingDataModelJsf");
        issueRuleSettingDataModelJsf.setIssueRuleSettingDtos(issueRuleSettingService.getAllIssueRuleSetting());
        return returnToPage();
    }
    public String initEdit(){
        issueRuleSettingDataModelJsf.setCreateEditPanel(true);
        loadDropdownMenus();
        return returnToPage();
    }
    private void loadDropdownMenus(){
        issueRuleSettingDataModelJsf.setBookDtos(issueRuleSettingService.getBookCategoryForDropdown());
        issueRuleSettingDataModelJsf.setMemberList(MemberTypeConstant.membersList());
        issueRuleSettingDataModelJsf.setSemesterList(SemesterConstant.semesterList());

    }
}
