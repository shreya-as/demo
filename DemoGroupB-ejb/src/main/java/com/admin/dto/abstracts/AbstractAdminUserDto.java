package com.admin.dto.abstracts;

import com.admin.dto.CollegeDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractAdminUserDto extends AbstractUserDto {

    private CollegeDto collegeDto;

    public CollegeDto getCollegeDto() {
        if (collegeDto == null) {
            collegeDto = new CollegeDto();
        }
        return collegeDto;
    }
}
