/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public abstract class AbstractBlockUnblockHelperDto extends AbstractStatusHelperDto {

    private Date lastUnBlockedDate;

    private Date lastBlockedDate;

    private AdminDto blockedByAdminDto;

    private AdminDto unBlockedByAdminDto;

    private String blockedReason;
    
    private String UnBlockedReason;

    public AdminDto getBlockedByAdminDto() {
        if (blockedByAdminDto == null) {
            blockedByAdminDto = new AdminDto();
        }
        return blockedByAdminDto;
    }

    public AdminDto getUnBlockedByAdminDto() {
        if (unBlockedByAdminDto == null) {
            unBlockedByAdminDto = new AdminDto();
        }
        return unBlockedByAdminDto;
    }

}
