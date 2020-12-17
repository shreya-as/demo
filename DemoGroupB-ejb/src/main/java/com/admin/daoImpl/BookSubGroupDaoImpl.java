/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.dao.BookSubGroupDao;
import com.payrollSystem.entity.common.BookSubGroup;
import javax.ejb.Stateless;

/**
 *
 * @author fox
 */
@Stateless
public class BookSubGroupDaoImpl extends StatusableDaoImpl<BookSubGroup> implements BookSubGroupDao {
    public BookSubGroupDaoImpl(){
        super(BookSubGroup.class);
    }
    
    
}
