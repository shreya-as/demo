package com.admin.mapper;

import com.admin.dto.abstracts.AbstractCodeDto;
import com.payrollSystem.entity.abstracts.AbstractCode;

/**
 *
 * @author paawan.bhatt
 */
public abstract class AbstractCodeMapper extends AbstractProfileMapper {
    
    protected static <T extends AbstractCodeDto, K extends AbstractCode> void convertCommon(T abstractCodeDto, K abstractCode) {
        abstractCodeDto.setCode(abstractCode.getCode());
        convertCommonParameters(abstractCodeDto, abstractCode);
    }
}
