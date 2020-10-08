package com.admin.dto;

import com.admin.dto.abstracts.AbstractBlockUnblockHelperDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollegeDto extends AbstractBlockUnblockHelperDto {

    private String name;

    private String address;

    private Integer establishedYear;

    private String collegeLogoPath;

    private String code;
    
    private String email;
    
    private String contact;

    private List<AdminDto> adminDtos;

    private AdminDto transientadminDto;

    private String realAttachmentName;

    private boolean transientShowResendActiationLinkPanel;

    private boolean transientSelected;

    public AdminDto getTransientadminDto() {
        if (transientadminDto == null) {
            transientadminDto = new AdminDto();
        }
        return transientadminDto;
    }
 

}
