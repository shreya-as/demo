package com.admin.mapper;

import com.admin.dto.DepartmentDto;
import com.payrollSystem.entity.common.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentMapper extends AbstractCodeMapper {

    public static DepartmentDto convertToDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        convertCommon(departmentDto, department);
        return departmentDto;
    }

    public static List<DepartmentDto> convertToDtos(List<Department> departments) {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Department department : departments) {
            departmentDtos.add(convertToDto(department));
        }
        return departmentDtos;
    }

    public static DepartmentDto convertToDtoForDropDown(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setCode(department.getCode());
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        return departmentDto;
    }
    
    public static List<DepartmentDto> convertToDtosForDropDown(List<Department> departments) {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for (Department department : departments) {
            departmentDtos.add(convertToDtoForDropDown(department));
        }
        return departmentDtos;
    }
}
