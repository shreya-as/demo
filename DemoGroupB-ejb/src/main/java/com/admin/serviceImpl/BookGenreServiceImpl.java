/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.serviceImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dao.BookGenreDao;
import com.admin.dao.StatusDao;
import com.admin.dto.BookGenreDto;
import com.admin.mapper.BookGenreMapper;
import com.admin.mapper.BookGroupMapper;
import com.admin.service.BookGenreService;
import com.payrollSystem.entity.common.BookGenre;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author fox
 */
@Stateless
public class BookGenreServiceImpl implements BookGenreService {
@EJB
    private AdminDao adminDao;
    @EJB
    private StatusDao statusDao;
    @EJB
    private BookGenreDao bookGenreDao;
    
     @Override
    public boolean save(BookGenreDto bookgenredto) {
return bookGenreDao.save(convertToBookGenre(bookgenredto));
        }
    private BookGenre convertToBookGenre(BookGenreDto bookgenredto) {
        BookGenre c = new BookGenre();

       c.setId(bookgenredto.getId());
        c.setCreatedDate(bookgenredto.getCreatedDate());
        c.setDeletedDate(bookgenredto.getDeletedDate());
        c.setLastUpdatedDate(bookgenredto.getLastUpdatedDate());
        c.setName(bookgenredto.getName());
        c.setStatus(statusDao.getByDesc(StatusConstants.CREATE_APPROVE.getName()));
        c.setDescription(bookgenredto.getDescription());
        return c;
    }
    private void setCreateEditCommonParameters(BookGenre bc, BookGenreDto bookgenredto) {

    bc.setName(bookgenredto.getName());
    bc.setDescription(bookgenredto.getDescription());
    }


    @Override
    public boolean edit(BookGenreDto bookgenredto) {
 BookGenre bc = bookGenreDao.getById(bookgenredto.getId());
 bc.setLastUpdatedDate(new Date());
        bc.setUpdatedByAdmin(adminDao.getById(bookgenredto.getUpdatedByAdminDto().getId()));
        bc.setStatus(statusDao.getByDesc(StatusConstants.EDIT_APPROVE.getName()));
        setCreateEditCommonParameters(bc, bookgenredto);
        return bookGenreDao.modify(bc);
    }

    @Override
    public boolean delete(BookGenreDto bookgenredto) {
 BookGenre bc   = bookGenreDao.getById(bookgenredto.getId());
        bc.setDeletedDate(new Date());
        bc.setDeletedReason(bookgenredto.getDeletedReason());
        bc.setDeletedByAdmin(adminDao.getById(bookgenredto.getDeletedByAdminDto().getId()));
        bc.setStatus(statusDao.getByDesc(StatusConstants.DELETED_APPROVE.getName()));
        return bookGenreDao.modify(bc);
    }

   
    @Override
    public List<BookGenreDto> getAllBooks() {
        return  BookGenreMapper.convertToDtos( bookGenreDao.findAll());
    }

        
}
