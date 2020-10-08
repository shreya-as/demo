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
public abstract class AbstractAttachedFileHelper extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "PATH")
    private String path;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;
}
