/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.BookGroupDao;
import com.admin.dto.BookGroupDto;
import com.payrollSystem.entity.common.BookGroup;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author fox
 */
@Stateless
public class BookGroupDaoImpl extends StatusableDaoImpl<BookGroup> implements BookGroupDao{
   public BookGroupDaoImpl(){
       super(BookGroup.class);
   }
   }