package com.payrollSystem.entity.common;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Branch.class)
public abstract class Branch_ {

	public static volatile SingularAttribute<Branch, String> branchCode;
	public static volatile SingularAttribute<Branch, College> college;
	public static volatile SingularAttribute<Branch, String> branchManager;
	public static volatile SingularAttribute<Branch, String> branchName;
	public static volatile SingularAttribute<Branch, String> branchAddress;
	public static volatile SingularAttribute<Branch, Long> id;
	public static volatile SingularAttribute<Branch, Date> branchEstablishedDate;
	public static volatile SingularAttribute<Branch, Boolean> isMainBranch;
	public static volatile SingularAttribute<Branch, Status> status;

}

