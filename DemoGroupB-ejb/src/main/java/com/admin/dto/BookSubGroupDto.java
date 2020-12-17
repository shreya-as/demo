/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dto;

import com.admin.dto.abstracts.AbstractCodeDto;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fox
 */
@Getter
@Setter

public class BookSubGroupDto extends AbstractCodeDto {
    private BookGroupDto bookGroupDto;
    
    public BookGroupDto getBookGroupDto() {
        if (bookGroupDto == null) {
            bookGroupDto = new BookGroupDto();
        }
        return bookGroupDto;
    }

}
