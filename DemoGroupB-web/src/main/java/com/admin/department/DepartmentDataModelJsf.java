/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.department;

import com.admin.dto.DepartmentDto;
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
public class DepartmentDataModelJsf implements Serializable {

    private DepartmentDto departmentDto;
    private boolean createEditPanel;
    private List<DepartmentDto> departmentDtos;

    public DepartmentDto getDepartmentDto() {
        if (departmentDto == null) {
            departmentDto = new DepartmentDto();
        }
        return departmentDto;
    }
}
