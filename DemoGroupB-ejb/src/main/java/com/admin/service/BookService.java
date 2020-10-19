/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.service;

import com.admin.dto.BookDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fox
 */
@Local
public interface BookService {
   
boolean edit(BookDto bookdto);
boolean delete(BookDto bookdto);
boolean save(BookDto bookdto);

        
     List<BookDto> getAllBooks();





    
}
