package com.payrollSystem.entity.abstracts;

import com.payrollSystem.entity.common.Admin;
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
public abstract class AbstractChangedByHelper extends AbstractEntity {

    @Column(name = "CREATED_DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "LAST_UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;

    @JoinColumn(name = "UPDATED_BY_ADMIN", referencedColumnName = "ID", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin updatedByAdmin;

    @JoinColumn(name = "CREATED_BY_ADMIN", referencedColumnName = "ID", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin createdByAdmin;

}
