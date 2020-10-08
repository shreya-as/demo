/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import com.payrollSystem.entity.common.Gender;
import javax.ejb.Local;

/**
 *
 * @author sanjeena
 */
@Local
public interface GenderDao {
   public Gender getByGenderName(String name);  
}
