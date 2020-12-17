/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractProfile;
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
@Table(name = "BOOK_SUB_GROUP")
public class BookSubGroup extends AbstractProfile {
        @JoinColumn(name = "BOOK_GROUP", referencedColumnName = "ID", nullable = false)
        @ManyToOne(optional = true, fetch = FetchType.LAZY)
        private BookGroup bookGroup ;
}
