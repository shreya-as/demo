package com.payrollSystem.entity.common;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(College.class)
public abstract class College_ extends com.payrollSystem.entity.abstracts.AbstractBlockUnblockHelper_ {

	public static volatile SingularAttribute<College, String> collegeLogoPath;
	public static volatile SingularAttribute<College, String> code;
	public static volatile SingularAttribute<College, String> address;
	public static volatile SingularAttribute<College, String> contact;
	public static volatile SingularAttribute<College, String> name;
	public static volatile SingularAttribute<College, Integer> establishedYear;
	public static volatile SingularAttribute<College, String> email;
	public static volatile ListAttribute<College, Admin> admins;

}

