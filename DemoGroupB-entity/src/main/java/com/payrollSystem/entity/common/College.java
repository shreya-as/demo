package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractBlockUnblockHelper;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COLLEGE")
public class College extends AbstractBlockUnblockHelper {

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "ESTABLISHED_YEAR", nullable = false)
    private Integer establishedYear;

    @Column(name = "COLLEGE_LOGO_PATH", nullable = false)
    private String collegeLogoPath;

    @Column(name = "EMAIL", nullable = false)
    private String email;
    
    @Column(name = "CONTACT", nullable = false)
    private String contact;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "college", fetch = FetchType.LAZY)
    private List<Admin> admins;

}
