/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sarita.joshi
 */
@Getter
@Setter
@Entity
@Table(name = "admin_role")
@NamedQueries({
    @NamedQuery(name = "AdminRole.findAll", query = "SELECT a FROM AdminRole a"),
    @NamedQuery(name = "AdminRole.findByAdminRoleId", query = "SELECT a FROM AdminRole a WHERE a.adminRoleId = :adminRoleId"),
    @NamedQuery(name = "AdminRole.findByAdminRoleDesc", query = "SELECT a FROM AdminRole a WHERE a.adminRoleDesc = :adminRoleDesc"),
    @NamedQuery(name = "AdminRole.findByAdminRoleName", query = "SELECT a FROM AdminRole a WHERE a.adminRoleName = :adminRoleName")})
public class AdminRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "admin_role_id", nullable = false)
    private Long adminRoleId;

    @Basic(optional = true)
    @Column(name = "admin_role_desc", nullable = false, length = 100)
    private String adminRoleDesc;

    @Basic(optional = true)
    @Column(name = "admin_role_name", nullable = false, length = 100)
    private String adminRoleName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminRole", fetch = FetchType.LAZY)
    private List<AdminRole> adminRoleList;

    @JoinColumn(name = "admin_parent_role_id", referencedColumnName = "admin_role_id", nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private AdminRole adminRole;

    @Transient
    boolean selected;

    @Column(name = "ui_role_name", length = 100)
    private String uiRoleName;

    @Column(name = "navigation", length = 100)
    private String navigation;

    @Column(name = "child_role_id", length = 45)
    private String childParentRoleId;

    @Column(name = "order_id")
    private int orderId;

}
