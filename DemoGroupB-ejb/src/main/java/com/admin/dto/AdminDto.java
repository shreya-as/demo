package com.admin.dto;

import com.admin.dto.abstracts.AbstractAdminEmployeeParentDto;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto extends AbstractAdminEmployeeParentDto {

    private BranchDto branchDto;

    private Boolean isCollegeSuperAdmin;

    private Boolean isCoordinator;

    private String panNumber;

    private Date joinedDate;

    private Boolean isDisabled;

    private Boolean isFullTimer;

    private Boolean isHod;

    private Boolean isSupervisor;

    private Boolean isSalaryMonthly;

    private Boolean isAttendanceCompulsory;

    private String maritalStatus;

    private int attendanceCode;

    private int employeeCode;

    private Date dateOfBirth;

    private GenderDto genderDto;

    private String bloodgroup;

    private String category;

    private Date dateOfConfirmation;

    private Integer citizenshipNumber;

    private DepartmentDto departmentDto;

    private DesignationDto designationDto;

    private Long homeTelephoneNumber;

    private String fatherName;

    private String motherName;

    private String spouseName;

    private String grandfatherName;

    private String remarks;
    
    public DepartmentDto getDepartmentDto() {
        if(departmentDto == null){
            departmentDto = new DepartmentDto();
        }
        return departmentDto;
    }

        public DesignationDto getDesignationDto() {
        if(designationDto == null){
            designationDto = new DesignationDto();
        }
        return designationDto;
    }
  
    
}
