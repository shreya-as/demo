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
public abstract class AbstractDeletedByHelperDto extends AbstractChangedByHelperDto {

    private Date deletedDate;

    private AdminDto deletedByAdminDto;

    private String deletedReason;

    public AdminDto getDeletedByAdminDto() {
        if (deletedByAdminDto == null) {
            deletedByAdminDto = new AdminDto();
        }
        return deletedByAdminDto;
    }

}
