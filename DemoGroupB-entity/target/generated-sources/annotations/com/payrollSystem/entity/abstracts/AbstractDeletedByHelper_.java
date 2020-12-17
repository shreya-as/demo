package com.payrollSystem.entity.abstracts;

import com.payrollSystem.entity.common.Admin;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractDeletedByHelper.class)
public abstract class AbstractDeletedByHelper_ extends com.payrollSystem.entity.abstracts.AbstractChangedByHelper_ {

	public static volatile SingularAttribute<AbstractDeletedByHelper, String> deletedReason;
	public static volatile SingularAttribute<AbstractDeletedByHelper, Date> deletedDate;
	public static volatile SingularAttribute<AbstractDeletedByHelper, Admin> deletedByAdmin;

}

