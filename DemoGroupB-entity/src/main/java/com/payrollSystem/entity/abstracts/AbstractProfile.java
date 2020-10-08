package com.payrollSystem.entity.abstracts;

import javax.persistence.Column;
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
public abstract class AbstractProfile extends AbstractStatusHelper {

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION",length = 2000)
    private String description;

}
