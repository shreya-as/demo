/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractAdminEmployeeParent;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sarita.joshi
 */
@Getter
@Setter
@Entity
@Table(name = "ADMIN")
public class Admin extends AbstractAdminEmployeeParent {

    @Basic(optional = true)
    @JoinColumn(name = "BRANCH", referencedColumnName = "branch_id", nullable = false)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Branch branch;

    @Column(name = "IS_COLLEGE_SUPER_ADMIN")
    private Boolean isCollegeSuperAdmin;

    @Column(name = "IS_COORDINATOR")
    private Boolean isCoordinator;

    @Column(name = "PAN_NUMBER")
    private String panNumber;

    @Column(name = "JOINED_DATE")
    @Temporal(TemporalType.DATE)
    private Date joinedDate;

    @Column(name = "IS_DISABLED")
    private Boolean isDisabled;

    @Column(name = "IS_FULL_TIMER")
    private Boolean isFullTimer;

    @Column(name = "IS_HOD")
    private Boolean isHod;

    @Column(name = "IS_SUPERVISOR")
    private Boolean isSupervisor;

    @Column(name = "IS_SALAY_MONTHLY")
    private Boolean isSalaryMonthly;

    @Column(name = "IS_ATTENDANCE_COMPULSORY")
    private Boolean isAttendanceCompulsory;

    @Column(name = "MARITAL_STATUS", nullable = false)
    private String maritalStatus;

    @Column(name = "ATTENDANCE_CODE", nullable = false)
    private int attendanceCode;

    @Column(name = "EMP_CODE")
    private int employeeCode;

    @Column(name = "DATE_OF_BIRTH")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @JoinColumn(name = "GENDER", referencedColumnName = "ID", nullable = true)
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    private Gender gender;

    @Column(name = "BLOOD_GROUP")
    private String bloodgroup;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DATE_OF_CONFIRMATION")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateOfConfirmation;

    @Column(name = "CITIZENSHIP_NUMBER")
    private Integer citizenshipNumber;

    @JoinColumn(name = "DEPARTMENT", referencedColumnName = "ID", nullable = true)
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    private Department department;

    @JoinColumn(name = "DESIGNATION", referencedColumnName = "ID", nullable = true)
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    private Designation designation;

    @Column(name = "HOME_TELEPHONE_NUMBER")
    private Long homeTelephoneNumber;

    @Column(name = "FATHER_NAME")
    private String fatherName;

    @Column(name = "MOTHER_NAME")
    private String motherName;

    @Column(name = "SPOUSE_NAME")
    private String spouseName;

    @Column(name = "GRAND_FATHER_NAME")
    private String grandFatherName;

    @Column(name = "REMARKS")
    private String remarks;

}
