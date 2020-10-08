/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "branch")
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByBranchId", query = "SELECT b FROM Branch b WHERE b.id = :id"),
    @NamedQuery(name = "Branch.findByBranchName", query = "SELECT b FROM Branch b WHERE b.branchName = :branchName"),
    @NamedQuery(name = "Branch.findByBranchAddress", query = "SELECT b FROM Branch b WHERE b.branchAddress = :branchAddress"),
    @NamedQuery(name = "Branch.findByBranchManager", query = "SELECT b FROM Branch b WHERE b.branchManager = :branchManager"),
    @NamedQuery(name = "Branch.findByBranchEstablishedDate", query = "SELECT b FROM Branch b WHERE b.branchEstablishedDate = :branchEstablishedDate")})
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "branch_id", nullable = false)
    private Long id;
    
    @Basic(optional = true)
    @Column(name = "branch_name", nullable = false, length = 45)
    private String branchName;
    
    @Basic(optional = true)
    @Column(name = "branch_address", nullable = false, length = 45)
    private String branchAddress;
    
    @Column(name = "branch_established_date")
    @Temporal(TemporalType.DATE)
    private Date branchEstablishedDate;
    
    @Column(name = "branch_manager", length = 45)
    private String branchManager;

    @Column(name = "is_main_branch", nullable = false)
    private boolean isMainBranch;
    
    @Column(name = "branch_code", length = 45)
    private String branchCode;
    
    @JoinColumn(name = "branch_status", referencedColumnName = "status_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;

    @JoinColumn(name = "COLLEGE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private College college;
}
