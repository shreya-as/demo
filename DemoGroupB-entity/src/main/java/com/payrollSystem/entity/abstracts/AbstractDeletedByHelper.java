package com.payrollSystem.entity.abstracts;

import com.payrollSystem.entity.common.Admin;
import com.payrollSystem.entity.common.Status;
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
public abstract class AbstractDeletedByHelper extends AbstractChangedByHelper {

    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @JoinColumn(name = "DELETED_BY_ADMIN", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin deletedByAdmin;
    
    @Column(name = "DELETED_REASON", nullable = true, length = 255)
    private String deletedReason;
    
}
