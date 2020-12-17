/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookGenre;

import com.admin.dto.BookGenreDto;
import java.io.Serializable;
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
public class BookGenreDataModelJsf implements Serializable {
     private BookGenreDto bookGenreDto;
    private boolean createEditPanel;
    private List<BookGenreDto> BookGenreDtos ;

    public BookGenreDto getBookGenreDto() {
        if (bookGenreDto == null) {
            bookGenreDto = new BookGenreDto();
        }
        return bookGenreDto;
    }

    
}
