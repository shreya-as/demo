/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookSubGroup;

import com.admin.dto.AdminDto;
import com.admin.dto.BookSubGroupDto;
import com.admin.dto.CollegeDto;
import com.admin.dto.StatusDto;
import com.admin.service.BookSubGroupService;
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

public class BookSubGroupBeanJsf {
     @ManagedProperty(value = "#{bookSubGroupDataModelJsf}")
    private  BookSubGroupDataModelJsf bookSubGropuDataModelJsf;
     
    private AdminDto adminDto;
    private CollegeDto collegeDto;
    private StatusDto statusDto;
    private boolean edit;
 

    
    @EJB
    private BookSubGroupService bookService;
 @PostConstruct
    public void init(){
       adminDto = new AdminDto();
       adminDto.setId(1L);
         collegeDto = new CollegeDto();
        collegeDto.setId(1l);


    }

    
     public String returnToPage() {
        return "bookSubGroup.xhtml?faces-redirect=true";
    }

        public String initCreate() {
        bookSubGropuDataModelJsf.setBookSubGroupDto(new BookSubGroupDto());
        bookSubGropuDataModelJsf.setCreateEditPanel(true);
        return returnToPage();
    }
    
        
public String saveUpdate() {
        bookSubGropuDataModelJsf.getBookSubGroupDto().setUpdatedByAdminDto(adminDto);
        bookSubGropuDataModelJsf.getBookSubGroupDto().setCreatedByAdminDto(adminDto);

        if (bookSubGropuDataModelJsf.getBookSubGroupDto().getId() == null) {
            return save();
        
        }
        return edit();
    }
private String edit() {
        boolean success = bookService.edit(bookSubGropuDataModelJsf.getBookSubGroupDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfully", null));
        }
        return navigateToPage();
    }

    private String save() {
        
        boolean response = bookService.save(bookSubGropuDataModelJsf.getBookSubGroupDto());
        if (response) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Saved", null));
                             

        }
        return navigateToPage();
    }
   



    public String navigateToPage() {
        Utility.removeSessionBeanJSFDataModelObject("bookSubGroupDataModelJsf");
        bookSubGropuDataModelJsf = (BookSubGroupDataModelJsf) Utility.getSessionObject("bookSubGroupDataModelJsf");
        bookSubGropuDataModelJsf.setBookSubGroupDtos(bookService.getAllBooks());
                return returnToPage();
    }

    public String initEdit() {
        bookSubGropuDataModelJsf.setCreateEditPanel(true);
                edit = true;


        return returnToPage();
    }

 public String delete(BookSubGroupDto bookdto) {
        bookSubGropuDataModelJsf.getBookSubGroupDto().setDeletedByAdminDto(adminDto);

        boolean success = bookService.delete(bookSubGropuDataModelJsf.getBookSubGroupDto());
        if (success) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfully", null));

        }
        return navigateToPage();
    }

       public void cancelEdit(){
      
        edit=false;

    }

       


}