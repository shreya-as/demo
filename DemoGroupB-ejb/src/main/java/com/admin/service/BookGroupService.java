/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.service;

import com.admin.dto.BookGroupDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fox
 */
@Local
public interface BookGroupService {
     public boolean edit( BookGroupDto bookgroupdto);

    boolean delete( BookGroupDto bookgroupdto);
    boolean save( BookGroupDto bookgroupdto);
    List<BookGroupDto> getAllBooks();
    
}
