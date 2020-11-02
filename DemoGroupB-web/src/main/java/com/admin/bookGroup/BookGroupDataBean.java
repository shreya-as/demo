/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookGroup;

import com.admin.dto.BookGroupDto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fox
 */
@Setter
@Getter
@ManagedBean
@SessionScoped
public class BookGroupDataBean {
      private BookGroupDto bookGroupDto;
    private boolean createEditPanel;
    private List<BookGroupDto> bookDtos ;

    public BookGroupDto getBookDto() {
        if (bookGroupDto == null) {
            bookGroupDto = new BookGroupDto();
        }
        return bookGroupDto;
    }

   
}
