/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractProfile;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sarita.joshi
 */
@Getter
@Setter
@Entity
@Table(name = "ADMIN_PROFILE")
@NamedQueries({
    @NamedQuery(name = "AdminProfile.findAll", query = "SELECT a FROM AdminProfile a WHERE a.createdByAdmin.college.id=:collegeId and a.status.statusDesc not in (:deleteStatusList)"),
    @NamedQuery(name = "AdminProfile.findByAdminProfileId", query = "SELECT a FROM AdminProfile a WHERE a.id = :id"),
    @NamedQuery(name = "AdminProfile.findByAdminProfileCreatedDate", query = "SELECT a FROM AdminProfile a WHERE a.createdDate = :createdDate"),
    @NamedQuery(name = "AdminProfile.findByAdminProfileDescription", query = "SELECT a FROM AdminProfile a WHERE a.description = :description"),
    @NamedQuery(name = "AdminProfile.findByAdminProfileName", query = "SELECT a FROM AdminProfile a WHERE a.description = :description")})

public class AdminProfile extends AbstractProfile {

    @OneToMany(mappedBy = "adminProfile", fetch = FetchType.LAZY)
    private List<AdminProfileRoleMap> adminProfileRoleMapList;

}
