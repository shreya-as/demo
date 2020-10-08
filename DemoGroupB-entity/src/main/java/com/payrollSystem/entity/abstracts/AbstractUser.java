package com.payrollSystem.entity.abstracts;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sarita.joshi
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractUser extends AbstractBlockUnblockHelper {

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IS_LOGGED_IN")
    private boolean isLoggedIn;

    @Column(name = "LAST_LOGGED_IN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoggedInTime;

    @Column(name = "LAST_PASSWORD_CHANGED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordChangedDate;

    @Column(name = "IS_BLOCKED")
    private boolean isBlocked;

    @Column(name = "WRONG_PASSWORD_ATTEMPT_COUNT")
    private Integer wrongPasswordAttemptCount;

    @Column(name = "SESSION_ID", nullable = true)
    private String sessionId;

    @Column(name = "IS_ACTIVATED_ON_PROMPT_PASSWORD")
    private boolean isActivatedOnPromptPassword;

    @Column(name = "ACTIVATION_CODE_ON_PROMPT_PASSWORD", nullable = true)
    private String activationCodeOnPromptPassword;

    @Column(name = "IS_PROMPT_PASSWORD")
    private boolean isPromptPassword;
    
    @Column(name = "IMAGE_PATH")
    private String imagePath;

}
