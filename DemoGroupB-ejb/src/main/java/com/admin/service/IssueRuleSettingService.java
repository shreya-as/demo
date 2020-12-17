/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.service;

import com.admin.dto.BookDto;
import com.admin.dto.IssueRuleSettingDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fox
 */
@Local
public interface IssueRuleSettingService {
        boolean createIssueRuleSetting(IssueRuleSettingDto issueRuleSettingDto);
    boolean updateIssueRuleSetting(IssueRuleSettingDto issueRuleSettingDto);
    boolean deleteIssueRuleSetting(IssueRuleSettingDto issueRuleSettingDto);
    boolean checkIfMemberAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);
    boolean checkIfSemesterAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);
    boolean checkIfBookCategoryAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);
    List<IssueRuleSettingDto> getAllIssueRuleSetting();
    boolean checkIfIssueSettingAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);
    List<BookDto> getBookCategoryForDropdown();


}
