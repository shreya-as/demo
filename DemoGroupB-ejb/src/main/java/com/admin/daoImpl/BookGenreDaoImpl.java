/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.dao.BookGenreDao;
import com.payrollSystem.entity.common.BookGenre;
import javax.ejb.Stateless;

/**
 *
 * @author fox
 */
@Stateless
public class BookGenreDaoImpl extends StatusableDaoImpl<BookGenre> implements BookGenreDao {
    public  BookGenreDaoImpl(){
        super(BookGenre.class);
    }
}
