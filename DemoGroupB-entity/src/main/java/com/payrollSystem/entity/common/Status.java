/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "status")
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByStatusId", query = "SELECT s FROM Status s WHERE s.statusId = :statusId"),
    @NamedQuery(name = "Status.findByName", query = "SELECT s FROM Status s WHERE s.name = :name"),
    @NamedQuery(name = "Status.findByStatusDesc", query = "SELECT s FROM Status s WHERE s.statusDesc = :statusDesc")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "status_id", nullable = false)
    private Long statusId;
    
    @Basic(optional = true)
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @Basic(optional = true)
    @Column(name = "status_desc", nullable = false, length = 45)
    private String statusDesc;
    
    @Column(name = "ICON", length = 45)
    private String icon;
}
