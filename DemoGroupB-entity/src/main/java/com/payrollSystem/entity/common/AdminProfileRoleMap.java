/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.payrollSystem.entity.common;

import java.io.Serializable;
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

/**
 *
 * @author sarita.joshi
 */
@Entity
@Table(name = "admin_profile_role_map")
@NamedQueries({
    @NamedQuery(name = "AdminProfileRoleMap.findAll", query = "SELECT a FROM AdminProfileRoleMap a"),
    @NamedQuery(name = "AdminProfileRoleMap.findByAdminProfileRoleMapId", query = "SELECT a FROM AdminProfileRoleMap a WHERE a.adminProfileRoleMapId = :adminProfileRoleMapId")})
public class AdminProfileRoleMap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "admin_profile_role_map_id", nullable = false)
    private Long adminProfileRoleMapId;
    
    @JoinColumn(name = "admin_profile_id", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private AdminProfile adminProfile;
    
    @JoinColumn(name = "admin_role_id", referencedColumnName = "admin_role_id", nullable = false)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private AdminRole adminRole;
    
    @Column(name = "isActive")
    private boolean isActive;
    

    public AdminProfileRoleMap() {
    }

    public AdminProfileRoleMap(Long adminProfileRoleMapId) {
        this.adminProfileRoleMapId = adminProfileRoleMapId;
    }

    public Long getAdminProfileRoleMapId() {
        return adminProfileRoleMapId;
    }

    public void setAdminProfileRoleMapId(Long adminProfileRoleMapId) {
        this.adminProfileRoleMapId = adminProfileRoleMapId;
    }

    public AdminProfile getAdminProfile() {
        return adminProfile;
    }

    public void setAdminProfile(AdminProfile adminProfile) {
        this.adminProfile = adminProfile;
    }

    public AdminRole getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(AdminRole adminRole) {
        this.adminRole = adminRole;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminProfileRoleMapId != null ? adminProfileRoleMapId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof AdminProfileRoleMap)) {
            return false;
        }
        AdminProfileRoleMap other = (AdminProfileRoleMap) object;
        if ((this.adminProfileRoleMapId == null && other.adminProfileRoleMapId != null) || (this.adminProfileRoleMapId != null && !this.adminProfileRoleMapId.equals(other.adminProfileRoleMapId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fest.digitalboard.ejb.entities.AdminProfileRoleMap[adminProfileRoleMapId=" + adminProfileRoleMapId + "]";
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
