package com.payrollSystem.entity.abstracts;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractCode extends AbstractProfile {

    @Column(name = "CODE")
    private String code;
}
