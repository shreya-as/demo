package com.payrollSystem.entity.abstracts;

import com.payrollSystem.entity.common.College;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractAdminEmployeeParent extends AbstractAdmin {

    @JoinColumn(name = "COLLEGE", referencedColumnName = "ID", nullable = true)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private College college;
}
