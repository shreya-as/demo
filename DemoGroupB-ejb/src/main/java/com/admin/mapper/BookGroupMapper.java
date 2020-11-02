/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.BookGroupDto;
import com.payrollSystem.entity.common.BookGroup;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fox
 */
public class BookGroupMapper extends AbstractCodeMapper {
   
   public static BookGroupDto convertToDto(BookGroup book) {
        BookGroupDto bookDto = new BookGroupDto();
          bookDto.setId(book.getId());
        bookDto.setName(book.getName());
                bookDto.setDescription(book.getDescription());
        return bookDto;
    }

public static List<BookGroupDto> convertToDtos(List<BookGroup> Book ) {
        List<BookGroupDto> bookDtos = new ArrayList<>();
        for (BookGroup book : Book) {
            bookDtos.add(convertToDto(book));
        }   
        return bookDtos;
    }

    
    
}
