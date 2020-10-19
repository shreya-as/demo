/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.BookDto;
import com.payrollSystem.entity.common.BookCategory;

/**
 *
 * @author fox
 */
public class BookCategoryMapper extends AbstractCodeMapper {
     public static BookDto convertToDtos(BookCategory bc) {
        BookDto BookDto = new BookDto();
        BookDto.setName(bc.getName());
        BookDto.setId(bc.getId());
        return BookDto;
    }
}
