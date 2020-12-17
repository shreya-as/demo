package com.payrollSystem.entity.common;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AdminRole.class)
public abstract class AdminRole_ {

	public static volatile SingularAttribute<AdminRole, Long> adminRoleId;
	public static volatile SingularAttribute<AdminRole, String> uiRoleName;
	public static volatile SingularAttribute<AdminRole, String> navigation;
	public static volatile SingularAttribute<AdminRole, String> adminRoleName;
	public static volatile SingularAttribute<AdminRole, Integer> orderId;
	public static volatile SingularAttribute<AdminRole, String> adminRoleDesc;
	public static volatile SingularAttribute<AdminRole, String> childParentRoleId;
	public static volatile ListAttribute<AdminRole, AdminRole> adminRoleList;
	public static volatile SingularAttribute<AdminRole, AdminRole> adminRole;

}

