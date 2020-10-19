/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.serviceImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dao.BookDao;
import com.admin.dao.StatusDao;
import com.admin.dto.BookDto;
import com.admin.mapper.BookCategoryMapper;
import com.admin.service.BookService;
import com.payrollSystem.entity.common.BookCategory;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author fox
 */
@Stateless
public class BookServiceImpl implements BookService {
     @EJB
    private AdminDao adminDao;
    @EJB
    private StatusDao statusDao;
    @EJB
    private BookDao bookDao;

     @Override
    public boolean save(BookDto bookdto) {
        bookdto.setBookName("science");
        return bookDao.save(convertToBookCategory(bookdto));
        
    }

    private BookCategory convertToBookCategory(BookDto bookDto) {
        BookCategory c = new BookCategory();

       c.setId(bookDto.getId());
        c.setCreatedDate(bookDto.getCreatedDate());
        c.setDeletedDate(bookDto.getDeletedDate());
        c.setLastUpdatedDate(bookDto.getLastUpdatedDate());
        c.setName(bookDto.getName());
        c.setStatus(statusDao.getByDesc(StatusConstants.CREATE_APPROVE.getName()));
        c.setDescription(bookDto.getDescription());
        return c;
    }
   
private void setCreateEditCommonParameters(BookCategory c, BookDto bookDto) {
        c.setDescription(bookDto.getDescription());
        c.setName(bookDto.getName());
            }


    
    @Override
    public boolean edit(BookDto bookDto) {
BookCategory bc   = bookDao.getById(bookDto.getId());
 bc.setLastUpdatedDate(new Date());
        bc.setUpdatedByAdmin(adminDao.getById(bookDto.getUpdatedByAdminDto().getId()));



        setCreateEditCommonParameters(bc, bookDto);
        return bookDao.modify(bc);
    }

    @Override
    public boolean delete(BookDto bookDto) {
BookCategory bc   = bookDao.getById(bookDto.getId());
        bc.setDeletedDate(new Date());
        bc.setDeletedReason(bookDto.getDeletedReason());
        bc.setDeletedByAdmin(adminDao.getById(bookDto.getDeletedByAdminDto().getId()));
        bc.setStatus(statusDao.getByDesc(StatusConstants.DELETED_APPROVE.getName()));
        return bookDao.modify(bc);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return (List<BookDto>) BookCategoryMapper.convertToDtos((BookCategory) bookDao.findAll());

    }

   
    
    

    
    
    
    
}
