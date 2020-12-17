/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractStatusHelper;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fox
 */
@Getter
@Setter
@Entity
@Table(name = "ISSUE_RULE_SETTING")
public class IssueRuleSetting extends AbstractStatusHelper {
    @Column(name = "member_type",nullable = false)
    private String memberType;

    @Column(name = "semester",nullable = false)
    private int semester;

    @JoinColumn(name = "book_category",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private BookCategory bookCategory;

    @Column(name = "allowed_book_no",nullable = false)
    private int noOfBookAllowed;

    @Column(name="no_of_renews",nullable = false)
    private int noOfRenews;

    @Column(name = "no_of_days_for_renewal",nullable = false)
    private int noOfRenewalDays;

    @Column(name = "fine_per_extra_day",nullable = true)
    private double finePerExtraDay;

    
}
