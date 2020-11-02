/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.serviceImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dao.BookGroupDao;
import com.admin.dao.StatusDao;
import com.admin.dto.BookGroupDto;
import com.admin.mapper.BookGroupMapper;
import com.admin.service.BookGroupService;
import com.payrollSystem.entity.common.BookGroup;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author fox
 */

@Stateless
public class BookGroupServiceImpl  implements BookGroupService{
    @EJB
    private AdminDao adminDao;
    @EJB
    private StatusDao statusDao;
    @EJB
    private BookGroupDao bookgroupDao;
        @Override

    public boolean save(BookGroupDto bookgroupdto) {
return bookgroupDao.save(convertToBookGroup(bookgroupdto));
        }
    
    private BookGroup convertToBookGroup(BookGroupDto bookgroupDto) {
        BookGroup c = new BookGroup();

       c.setId(bookgroupDto.getId());
        c.setCreatedDate(bookgroupDto.getCreatedDate());
        c.setDeletedDate(bookgroupDto.getDeletedDate());
        c.setLastUpdatedDate(bookgroupDto.getLastUpdatedDate());
        c.setName(bookgroupDto.getName());
        c.setStatus(statusDao.getByDesc(StatusConstants.CREATE_APPROVE.getName()));
        c.setDescription(bookgroupDto.getDescription());
        return c;
    }
   
private void setCreateEditCommonParameters(BookGroup book, BookGroupDto bookgroupDto) {
        book.setDescription(bookgroupDto.getDescription());
        book.setName(bookgroupDto.getName());
            }

    @Override
    public boolean delete(BookGroupDto bookgroupdto) {
        BookGroup bc   = bookgroupDao.getById(bookgroupdto.getId());
        bc.setDeletedDate(new Date());
        bc.setDeletedReason(bookgroupdto.getDeletedReason());
        bc.setDeletedByAdmin(adminDao.getById(bookgroupdto.getDeletedByAdminDto().getId()));
        bc.setStatus(statusDao.getByDesc(StatusConstants.DELETED_APPROVE.getName()));
        return bookgroupDao.modify(bc);
    }
   
    @Override
    public boolean edit(BookGroupDto bookgroupdto) {
BookGroup bc   = bookgroupDao.getById(bookgroupdto.getId());
 bc.setLastUpdatedDate(new Date());
        bc.setUpdatedByAdmin(adminDao.getById(bookgroupdto.getUpdatedByAdminDto().getId()));
        bc.setStatus(statusDao.getByDesc(StatusConstants.EDIT_APPROVE.getName()));

        setCreateEditCommonParameters(bc, bookgroupdto);
        return bookgroupDao.modify(bc);
    }
     @Override
    public List<BookGroupDto> getAllBooks() {
        return  BookGroupMapper.convertToDtos( bookgroupDao.findAll());
    }

    
}
