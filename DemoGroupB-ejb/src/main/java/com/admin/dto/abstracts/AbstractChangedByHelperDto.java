package com.admin.dto.abstracts;

import com.admin.dto.AdminDto;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author manoj.lamsal
 */
@Getter
@Setter
public abstract class AbstractChangedByHelperDto extends AbstractDto {

    private Date createdDate;

    private Date lastUpdatedDate;

    private AdminDto updatedByAdminDto;

    private AdminDto createdByAdminDto;
    
    public AdminDto getUpdatedByAdminDto() {
        if (updatedByAdminDto == null) {
            updatedByAdminDto = new AdminDto();
        }
        return updatedByAdminDto;
    }

    public AdminDto getCreatedByAdminDto() {
        if (createdByAdminDto == null) {
            createdByAdminDto = new AdminDto();
        }
        return createdByAdminDto;
    }
}
