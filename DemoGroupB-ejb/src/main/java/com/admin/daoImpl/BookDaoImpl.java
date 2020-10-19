/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.dao.BookDao;
import com.payrollSystem.entity.common.BookCategory;
import javax.ejb.Stateless;

/**
 *
 * @author fox
 */
@Stateless
public class BookDaoImpl extends StatusableDaoImpl<BookCategory> implements BookDao{
      public BookDaoImpl() {
        super(BookCategory.class);
    }
    
      @Override
    public BookCategory getByBookName(String bookName){
         try {
                        return (BookCategory) getEntityManager()
                    .createQuery("SELECT b FROM " + getPersistenceClass().getSimpleName() + " b WHERE b.name = :name")
                    .setParameter("name", bookName)
                    .getSingleResult();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    

    
}
