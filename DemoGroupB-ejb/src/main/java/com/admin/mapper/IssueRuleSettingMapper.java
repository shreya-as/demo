/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.IssueRuleSettingDto;
import com.payrollSystem.entity.common.IssueRuleSetting;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fox
 */
public class IssueRuleSettingMapper extends AbstractStatusHelperMapper {
    public static List<IssueRuleSettingDto> convertToDtos(List<IssueRuleSetting> issueRuleSetting ) {
        List<IssueRuleSettingDto> issueRuleSettingDto = new ArrayList<>();
        for (IssueRuleSetting issueRule : issueRuleSetting) {
            issueRuleSettingDto.add(convertToDto(issueRule));
        }   
        return issueRuleSettingDto;
    }
    public static IssueRuleSettingDto convertToDto(IssueRuleSetting issueRule) {
       IssueRuleSettingDto issueRuleSettingDto = new IssueRuleSettingDto();
        issueRuleSettingDto.setMemberType(issueRule.getMemberType());
        issueRuleSettingDto.setSemester(issueRule.getSemester());
        issueRuleSettingDto.setNoOfRenews(issueRule.getNoOfRenews());
        issueRuleSettingDto.setNoOfBookAllowed(issueRule.getNoOfBookAllowed());
        issueRuleSettingDto.setNoOfRenewalDays(issueRule.getNoOfRenewalDays());
        issueRuleSettingDto.setFinePerExtraDay(issueRule.getFinePerExtraDay());
       issueRuleSettingDto.setBookCategoryDto(BookCategoryMapper.convertToDto(issueRule.getBookCategory()));


        return issueRuleSettingDto;
    }
}
