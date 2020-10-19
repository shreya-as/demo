/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractProfile;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fox
 */

@Entity
@Getter
@Setter
@Table(name = "BOOK_CATEGORY")


public class BookCategory extends AbstractProfile{
}  