/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractEntity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "GENDER")
@NamedQueries({
      @NamedQuery(name = "Gender.findAll", query = "SELECT g FROM Gender g"),
        @NamedQuery(name = "Gender.findByGenderName", query = "SELECT g FROM Gender g WHERE g.name = :name")})

public class Gender extends AbstractEntity {

    @Basic(optional = true)
    @Column(name = "NAME", nullable = false, length = 255)
    private String name;
}
