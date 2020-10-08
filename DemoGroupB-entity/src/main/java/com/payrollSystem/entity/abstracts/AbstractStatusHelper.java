package com.payrollSystem.entity.abstracts;

import com.payrollSystem.entity.common.Status;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sarita.joshi
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractStatusHelper extends AbstractDeletedByHelper {

    @JoinColumn(name = "STATUS", referencedColumnName = "status_id", nullable = false)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Status status;
}
