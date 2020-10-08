package com.admin.dto.abstracts;

import com.admin.dto.CollegeDto;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author manoj.lamsal
 */
@Getter
@Setter
public abstract class AbstractAdminEmployeeParentDto extends AbstractAdminDto {

    private CollegeDto collegeDto;

    public CollegeDto getCollegeDto() {
        if (collegeDto == null) {
            collegeDto = new CollegeDto();
        }
        return collegeDto;
    }
}
