/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.BookGenreDto;
import com.payrollSystem.entity.common.BookCategory;
import com.payrollSystem.entity.common.BookGenre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fox 
 */ 
public class BookGenreMapper extends AbstractProfileMapper{
   public static List<BookGenreDto> convertToDtos(List<BookGenre> Book ) {
        List<BookGenreDto> bookGenreDtos = new ArrayList<>();
        for (BookGenre book : Book) {
            bookGenreDtos.add(convertToDto(book));
        }   
        return bookGenreDtos;
    }

     public static BookGenreDto convertToDto(BookGenre book) {
        BookGenreDto bookGenreDto = new BookGenreDto();
          bookGenreDto.setId(book.getId());
        bookGenreDto.setName(book.getName());
                bookGenreDto.setDescription(book.getDescription());
        return bookGenreDto;
        
    }


}
