package com.payrollSystem.entity.abstracts;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractAdmin.class)
public abstract class AbstractAdmin_ extends com.payrollSystem.entity.abstracts.AbstractUser_ {

	public static volatile SingularAttribute<AbstractAdmin, String> firstName;
	public static volatile SingularAttribute<AbstractAdmin, String> lastName;
	public static volatile SingularAttribute<AbstractAdmin, String> mobileNumber;
	public static volatile SingularAttribute<AbstractAdmin, String> temporaryAddress;
	public static volatile SingularAttribute<AbstractAdmin, String> middleName;
	public static volatile SingularAttribute<AbstractAdmin, String> permanentAddress;
	public static volatile SingularAttribute<AbstractAdmin, String> email;

}

