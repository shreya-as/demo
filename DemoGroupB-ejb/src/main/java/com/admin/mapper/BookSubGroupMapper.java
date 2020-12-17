/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.BookSubGroupDto;
import com.payrollSystem.entity.common.BookSubGroup;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fox
 */
public class BookSubGroupMapper extends AbstractCodeMapper {
    

    public static List<BookSubGroupDto> ConvertToDtos(List<BookSubGroup> bookSubGroup){        
        
        List<BookSubGroupDto> BookSubGroupDto= new ArrayList<>();
        for(BookSubGroup bookSub: bookSubGroup){
            BookSubGroupDto.add(convertToDto(bookSub));
            
        }
        
            return BookSubGroupDto ;

    }

    public static BookSubGroupDto convertToDto(BookSubGroup bookSub) {
        BookSubGroupDto bookSubGroupDto= new BookSubGroupDto();
        bookSubGroupDto.setId(bookSub.getId());
        bookSubGroupDto.setName(bookSub.getName());
        bookSubGroupDto.setDescription(bookSub.getDescription());
        return bookSubGroupDto;
        
                
   
    }   
}
