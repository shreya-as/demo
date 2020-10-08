/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractCode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author user
 */
@Getter
@Setter
@Entity
@Table(name = "DESIGNATION")
@NamedQueries({
    @NamedQuery(name = "Designation.findAll", query = "SELECT de FROM Designation de"),
    @NamedQuery(name = "Designation.findByDesignationId", query = "SELECT de FROM Designation de WHERE de.id = :id")})
public class Designation extends AbstractCode {

    @Column(name = "BASIC_SALARY", nullable = false)
    private int basicSalary;

    @Column(name = "GRADE")
    private int grade;

}
