/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.abstracts;

import com.payrollSystem.entity.common.Admin;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public abstract class AbstractBlockUnblockHelper extends AbstractStatusHelper  {

    @Column(name = "LAST_UNBLOCKED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUnBlockedDate;

    @Column(name = "LAST_BLOCKED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastBlockedDate;

    @JoinColumn(name = "BLOCKED_BY_ADMIN", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin blockedByAdmin;

    @JoinColumn(name = "UNBLOCKED_BY_ADMIN", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin unBlockedByAdmin;
    
    @Column(name = "BLOCKED_REASON", nullable = true, length = 200)
    private String blockedReason;
    
    @Column(name = "UNBLOCKED_REASON", nullable = true, length = 200)
    private String unBlockedReason;

}
