/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.admin.dto.IssueRuleSettingDto;
import com.payrollSystem.entity.common.IssueRuleSetting;
import javax.ejb.Local;

/**
 *
 * @author fox
 */
@Local
public interface IssueRuleSettingDao extends StatusableDao<IssueRuleSetting>  {

    boolean checkIfMemberTypeAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);
    boolean checkIfSemesterAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);
    boolean checkIfBookCategoryAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);

}
