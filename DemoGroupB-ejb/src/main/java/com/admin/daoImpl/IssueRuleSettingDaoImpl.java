/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.IssueRuleSettingDao;
import com.admin.dto.IssueRuleSettingDto;
import com.payrollSystem.entity.common.IssueRuleSetting;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author fox
 */
@Stateless
public class IssueRuleSettingDaoImpl extends StatusableDaoImpl<IssueRuleSetting> implements IssueRuleSettingDao {
    public IssueRuleSettingDaoImpl(){
        super(IssueRuleSetting.class);
    }

      @Override
    public boolean checkIfMemberTypeAlreadyExists(IssueRuleSettingDto issueRuleSettingDto) {
 StringBuilder stringBuilder = new StringBuilder("SELECT count(s.id) from IssueRuleSetting s where s.memberType=:member AND " +
                "s.status.statusDesc !=:statusDesc");
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("member",issueRuleSettingDto.getMemberType());
        query.setParameter("statusDesc", StatusConstants.DELETED_APPROVE.getName());
        return (Long)query.getSingleResult() > 0;
    }

    @Override
    public boolean checkIfSemesterAlreadyExists(IssueRuleSettingDto issueRuleSettingDto) {
StringBuilder stringBuilder = new StringBuilder("SELECT count(s.id) from IssueRuleSetting s where s.semester=:semester AND " +
                "s.status.statusDesc !=:statusDesc");
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("semester",issueRuleSettingDto.getSemester());
        query.setParameter("statusDesc", StatusConstants.DELETED_APPROVE.getName());
        return (Long)query.getSingleResult() > 0;

    }

    @Override
    public boolean checkIfBookCategoryAlreadyExists(IssueRuleSettingDto issueRuleSettingDto) {
StringBuilder stringBuilder = new StringBuilder("SELECT count(s.id) from IssueRuleSetting s where s.bookCategory.id=:bookCategoryId AND " +
                "s.status.statusDesc !=:statusDesc");
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("bookCategoryId",issueRuleSettingDto.getBookCategoryDto().getId());
        query.setParameter("statusDesc", StatusConstants.DELETED_APPROVE.getName());
        return (Long)query.getSingleResult() > 0;

    }


}
