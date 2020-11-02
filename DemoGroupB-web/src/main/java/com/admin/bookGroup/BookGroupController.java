/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookGroup;

import com.admin.dto.AdminDto;
import com.admin.dto.BookDto;
import com.admin.dto.BookGroupDto;
import com.admin.dto.CollegeDto;
import com.admin.dto.StatusDto;
import com.admin.service.BookGroupService;
import com.admin.util.Utility;
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

public class BookGroupController {
     @ManagedProperty(value = "#{bookGroupDataBean}")
    private  BookGroupDataBean bookGroupDataBean;
     
    private AdminDto adminDto;
    private CollegeDto collegeDto;
    private StatusDto statusDto;
    private boolean edit;
 

    
    @EJB
    private BookGroupService bookService;
    
    @PostConstruct
    public void init(){
       adminDto = new AdminDto();
       adminDto.setId(1L);
         collegeDto = new CollegeDto();
        collegeDto.setId(1l);


    }

    
     public String returnToPage() {
        return "bookGroup.xhtml?faces-redirect=true";
    }

        public String initCreate() {
        bookGroupDataBean.setBookGroupDto(new BookGroupDto());
        bookGroupDataBean.setCreateEditPanel(true);
        return returnToPage();
    }
    
        
public String saveUpdate() {
        bookGroupDataBean.getBookGroupDto().setUpdatedByAdminDto(adminDto);
        bookGroupDataBean.getBookGroupDto().setCreatedByAdminDto(adminDto);

        if (bookGroupDataBean.getBookDto().getId() == null) {
            return save();
        
        }
        return edit();
    }
private String edit() {
        boolean success = bookService.edit(bookGroupDataBean.getBookDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfully", null));
        }
        return navigateToPage();
    }

    private String save() {
        
        boolean response = bookService.save(bookGroupDataBean.getBookDto());
        if (response) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Saved", null));
                             

        }
        return navigateToPage();
    }
  

    public String navigateToPage() {
        Utility.removeSessionBeanJSFDataModelObject("bookGropuDataBean");
        bookGroupDataBean = (BookGroupDataBean) Utility.getSessionObject("bookGroupDataBean");
        bookGroupDataBean.setBookDtos(bookService.getAllBooks());
                return returnToPage();
    }

    public String initEdit() {
        bookGroupDataBean.setCreateEditPanel(true);
                edit = true;


        return returnToPage();
    }

 public String delete(BookDto bookdto) {
        bookGroupDataBean.getBookDto().setDeletedByAdminDto(adminDto);

        boolean success = bookService.delete(bookGroupDataBean.getBookDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfully", null));

        }
        return navigateToPage();
    }

       public void cancelEdit(){
      
        edit=false;

    }


}
