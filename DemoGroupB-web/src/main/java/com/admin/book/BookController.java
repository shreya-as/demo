/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.book;

import com.admin.dto.AdminDto;
import com.admin.dto.BookDto;
import com.admin.dto.CollegeDto;
import com.admin.dto.StatusDto;
import com.admin.service.BookService;
import com.admin.util.Utility;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fox
 */
@Getter
@Setter
@ManagedBean
@RequestScoped
public class BookController {
    
    @ManagedProperty(value = "#{bookDataBean}")
    private  BookDataBean bookDataBean;
    private AdminDto adminDto;
    private CollegeDto collegeDto;
    private StatusDto statusDto;
    private boolean edit;
 

    
    @EJB
    private BookService bookService;
 @PostConstruct
    public void init(){
       adminDto = new AdminDto();
       adminDto.setId(1L);
         collegeDto = new CollegeDto();
        collegeDto.setId(1l);


    }

    
     public String returnToPage() {
        return "bookCategory.xhtml?faces-redirect=true";
    }

        public String initCreate() {
        bookDataBean.setBookDto(new BookDto());
        bookDataBean.setCreateEditPanel(true);
        return returnToPage();
    }
    
        
public String saveUpdate() {
        bookDataBean.getBookDto().setUpdatedByAdminDto(adminDto);
        bookDataBean.getBookDto().setCreatedByAdminDto(adminDto);

        if (bookDataBean.getBookDto().getId() == null) {
            return save();
        
        }
        return edit();
    }
private String edit() {
        boolean success = bookService.edit(bookDataBean.getBookDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfully", null));
        }
        return navigateToPage();
    }

    private String save() {
        
        boolean response = bookService.save(bookDataBean.getBookDto());
        if (response) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Saved", null));
                             

        }
        return navigateToPage();
    }
   



    public String navigateToPage() {
        Utility.removeSessionBeanJSFDataModelObject("bookDataBean");
        bookDataBean = (BookDataBean) Utility.getSessionObject("bookDataBean");
        bookDataBean.setBookDtos(bookService.getAllBooks());
                return returnToPage();
    }

    public String initEdit() {
        bookDataBean.setCreateEditPanel(true);
                edit = true;


        return returnToPage();
    }

 public String delete(BookDto bookdto) {
        bookDataBean.getBookDto().setDeletedByAdminDto(adminDto);

        boolean success = bookService.delete(bookDataBean.getBookDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfully", null));

        }
        return navigateToPage();
    }

       public void cancelEdit(){
      
        edit=false;

    }

       

}
