/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.serviceImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dao.BookGroupDao;
import com.admin.dao.BookSubGroupDao;
import com.admin.dao.StatusDao;
import com.admin.dto.BookSubGroupDto;
import com.admin.mapper.BookSubGroupMapper;
import com.admin.service.BookSubGroupService;
import com.payrollSystem.entity.common.BookSubGroup;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author fox
 */
@Stateless
public class BookSubGroupImpl implements BookSubGroupService{

    @EJB
    private AdminDao adminDao;
    @EJB
    private StatusDao statusDao;
    @EJB
    private BookSubGroupDao BookSubGroupDao;
    
   @EJB
   private  BookGroupDao bookGroupDao;
   
      @Override
    public boolean save(BookSubGroupDto booksubgroup) {
       return BookSubGroupDao.save(convertToBookSubGroup(booksubgroup));
    }
    private BookSubGroup convertToBookSubGroup(BookSubGroupDto booksubgroup){
                BookSubGroup bookSubGroup = new BookSubGroup();
        bookSubGroup.setCreatedByAdmin(adminDao.getById(booksubgroup.getCreatedByAdminDto().getId()));
        bookSubGroup.setCreatedDate(new Date());
        bookSubGroup.setName(booksubgroup.getName());
        bookSubGroup.setBookGroup(bookGroupDao.getById(booksubgroup.getBookGroupDto().getId()));

        bookSubGroup.setDescription(booksubgroup.getDescription());
        bookSubGroup.setStatus(statusDao.getByDesc(StatusConstants.CREATE_APPROVE.getName()));
        return bookSubGroup;
    }
    

    @Override
    public boolean edit(BookSubGroupDto booksubgroup) {
        BookSubGroup bc  = BookSubGroupDao.getById(booksubgroup.getId());
        bc.setLastUpdatedDate(new Date());
        bc.setUpdatedByAdmin(adminDao.getById(booksubgroup.getUpdatedByAdminDto().getId()));

        bc.setStatus(statusDao.getByDesc(StatusConstants.EDIT_APPROVE.getName()));
        setCreateEditCommonParameters(bc, booksubgroup);
         return BookSubGroupDao.modify(bc);
    }
        private void setCreateEditCommonParameters(BookSubGroup bookSubGroup,BookSubGroupDto bookSubGroupDto){
            bookSubGroup.setName(bookSubGroupDto.getName());
            bookSubGroup.setDescription(bookSubGroupDto.getDescription());
            
        }

    @Override
    public boolean delete(BookSubGroupDto booksubgroup) {
        BookSubGroup bc= BookSubGroupDao.getById(booksubgroup.getId());
        bc.setDeletedDate(new Date());
        bc.setDeletedReason(booksubgroup.getDeletedReason());
        bc.setDeletedByAdmin(adminDao.getById(booksubgroup.getDeletedByAdminDto().getId()));
        bc.setStatus(statusDao.getByDesc(StatusConstants.DELETED_APPROVE.getName()));
        return BookSubGroupDao.modify(bc);
     
    }

      @Override
    public List<BookSubGroupDto> getAllBooks() {
        return BookSubGroupMapper.ConvertToDtos(BookSubGroupDao.findAll());
        
    }
    
}
