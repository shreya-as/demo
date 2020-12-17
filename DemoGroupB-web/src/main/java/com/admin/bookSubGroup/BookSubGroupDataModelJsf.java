/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookSubGroup;

import com.admin.dto.BookSubGroupDto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fox
 */
@Getter

@Setter
@ManagedBean
@SessionScoped
public class BookSubGroupDataModelJsf {
    
    private BookSubGroupDto bookSubGroupDto;
    private boolean createEditPanel;
    private List<BookSubGroupDto> BookSubGroupDtos;

    public BookSubGroupDto getBookSubGroupDto() {
        if (bookSubGroupDto == null) {
            bookSubGroupDto = new BookSubGroupDto();
        }
        return bookSubGroupDto;
    }
    
    
}
