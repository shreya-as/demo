/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dto.abstracts;

import com.admin.dto.BranchDto;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author manoj.lamsal
 */
@Getter
@Setter
public abstract class AbstractUserDto extends AbstractBlockUnblockHelperDto {

    private String username;

    private String password;

    private boolean isLoggedIn;

    private Date lastLoggedInTime;

    private Date lastPasswordChangedDate;

    private boolean isBlocked;

    private Integer wrongPasswordAttemptCount;

    private Date deletedDate;

    private String updatedByAdminUsername;

    private String createdByAdminUsername;

    private String deletedByAdminUsername;

    private String blockedByAdminUsername;

    private String unBlockedByAdminUsername;

    private String sessionId;

    private BranchDto branchDto;

    private String branchName;

    private boolean isActivatedOnPromptPassword;

    private String activationCodeOnPromptPassword;

    private boolean isPromptPassword;
    
    private boolean actionRender;

    private String blockedStatus;

    private boolean enableEdit;

    private String emailMessage;

    private Long loggedInAdminId;

    private boolean block;

    private boolean unblock;

    private boolean delete;

    private boolean approve;

    private String adminRole;

    private String imagePath;

    private String realAttachmentName;

    private boolean transientShowResendActiationLinkPanel;

    public BranchDto getBranchDto() {
        if (branchDto == null) {
            branchDto = new BranchDto();
        }
        return branchDto;
    }

}
