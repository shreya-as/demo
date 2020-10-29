/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
//        * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.BookDto;
import com.payrollSystem.entity.common.BookCategory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fox
 */
public class BookCategoryMapper extends AbstractCodeMapper {
     public static BookDto convertToDto(BookCategory book) {
        BookDto bookDto = new BookDto();
          bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        return bookDto;
    }

public static List<BookDto> convertToDtos(List<BookCategory> Book ) {
        List<BookDto> bookDtos = new ArrayList<>();
        for (BookCategory book : Book) {
            bookDtos.add(convertToDto(book));
        }
        return bookDtos;
    }

}
