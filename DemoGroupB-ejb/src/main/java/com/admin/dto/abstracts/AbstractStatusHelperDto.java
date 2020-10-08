package com.admin.dto.abstracts;

import com.admin.dto.StatusDto;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author manoj.lamsal
 */
@Getter
@Setter
public abstract class AbstractStatusHelperDto extends AbstractDeletedByHelperDto {

    private StatusDto statusDto;
    
    public StatusDto getStatusDto() {
        if (statusDto == null) {
            statusDto = new StatusDto();
        }
        return statusDto;
    }
}
