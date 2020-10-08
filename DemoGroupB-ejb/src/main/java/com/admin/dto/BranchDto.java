package com.admin.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchDto {

    private Long id;
    private String branchName;
    private String branchAddress;
    private Date branchEstablishedDate;
    private String branchManager;
    private boolean isMainBranch;
    private String branchCode;
    private StatusDto statusDto;
    private CollegeDto collegeDto;

    public StatusDto getStatusDto() {
        if (statusDto == null) {
            statusDto = new StatusDto();
        }
        return statusDto;
    }

    public CollegeDto getCollegeDto() {
        if (collegeDto == null) {
            collegeDto = new CollegeDto();
        }
        return collegeDto;
    }
}
