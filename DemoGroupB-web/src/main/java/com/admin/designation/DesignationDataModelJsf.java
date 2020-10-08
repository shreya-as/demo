/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.designation;


import com.admin.dto.DesignationDto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sanjeena
 */
@Getter
@Setter
@ManagedBean
@SessionScoped
public class DesignationDataModelJsf implements Serializable {
    private DesignationDto designationDto;
    private boolean createEditPanel;
    private List<DesignationDto> designationDtos;

    public DesignationDto getDesignationDto() {
        if (designationDto == null) {
            designationDto = new DesignationDto();
        }
        return designationDto;
    }   
}
