/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookGenre;

import com.admin.dto.AdminDto;
import com.admin.dto.BookGenreDto;
import com.admin.dto.CollegeDto;
import com.admin.dto.StatusDto;
import com.admin.service.BookGenreService;
import com.admin.util.Utility;
import java.io.Serializable;
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

public class BookGenreBeanJsf implements Serializable{
    @ManagedProperty(value = "#{bookGenreDataModelJsf}")
    private BookGenreDataModelJsf bookGenreDataModelJsf;
    private AdminDto adminDto;
    private CollegeDto collegeDto;
    private StatusDto statusDto;
    private boolean edit;
 

    
   @EJB
    private BookGenreService bookGenreService;
    
    @PostConstruct
    public void init(){
       adminDto = new AdminDto();
       adminDto.setId(1L);
         collegeDto = new CollegeDto();
        collegeDto.setId(1l);


    }

     public String returnToPage() {
        return "bookGenre.xhtml?faces-redirect=true";
    }

        public String initCreate() {
        bookGenreDataModelJsf.setBookGenreDto(new BookGenreDto());
        bookGenreDataModelJsf.setCreateEditPanel(true);
        return returnToPage();
    }
    
        
public String saveUpdate() {
        bookGenreDataModelJsf.getBookGenreDto().setUpdatedByAdminDto(adminDto);
        bookGenreDataModelJsf.getBookGenreDto().setCreatedByAdminDto(adminDto);

        if (bookGenreDataModelJsf.getBookGenreDto().getId() == null) {
            return save();
        
        }
        return edit();
    }
private String edit() {
        boolean success = bookGenreService.edit(bookGenreDataModelJsf.getBookGenreDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfully", null));
        }
        return navigateToPage();
    }

    private String save() {
        
        boolean response = bookGenreService.save(bookGenreDataModelJsf.getBookGenreDto());
        if (response) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Saved", null));
                             

        }
        return navigateToPage();
    }
   
    public String navigateToPage() {
        Utility.removeSessionBeanJSFDataModelObject("bookGenreDataModelJsf");
        bookGenreDataModelJsf = (BookGenreDataModelJsf) Utility.getSessionObject("bookGenreDataModelJsf");
        bookGenreDataModelJsf.setBookGenreDtos(bookGenreService.getAllBooks());
                return returnToPage();
    }

    public String initEdit() {
        bookGenreDataModelJsf.setCreateEditPanel(true);
                edit = true;


        return returnToPage();
    }

 public String delete(BookGenreDto bookdto) {
        bookGenreDataModelJsf.getBookGenreDto().setDeletedByAdminDto(adminDto);

        boolean success = bookGenreService.delete(bookGenreDataModelJsf.getBookGenreDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfully", null));

        }
        return navigateToPage();
    }

       public void cancelEdit(){
      
        edit=false;

    }

       

}
    