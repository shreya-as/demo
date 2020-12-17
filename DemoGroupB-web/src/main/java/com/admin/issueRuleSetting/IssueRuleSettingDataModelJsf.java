/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.issueRuleSetting;

import com.admin.dto.BookDto;
import com.admin.dto.IssueRuleSettingDto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fox
 */
@Getter
@Setter
@ManagedBean
@SessionScoped

class IssueRuleSettingDataModelJsf implements Serializable {
     private IssueRuleSettingDto issueRuleSettingDto;
    private List<IssueRuleSettingDto> issueRuleSettingDtos;
    private List<BookDto> bookDtos;
    private List<String> memberList;
    private List<Integer> semesterList;
    private boolean CreateEditPanel;

    public IssueRuleSettingDto getIssueRuleSettingDto(){
         if (issueRuleSettingDto == null) {
            issueRuleSettingDto = new IssueRuleSettingDto();
        }
        return issueRuleSettingDto;
    }

}
