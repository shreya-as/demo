package com.payrollSystem.entity.abstracts;

import com.payrollSystem.entity.common.Admin;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractChangedByHelper.class)
public abstract class AbstractChangedByHelper_ extends com.payrollSystem.entity.abstracts.AbstractEntity_ {

	public static volatile SingularAttribute<AbstractChangedByHelper, Admin> createdByAdmin;
	public static volatile SingularAttribute<AbstractChangedByHelper, Date> lastUpdatedDate;
	public static volatile SingularAttribute<AbstractChangedByHelper, Date> createdDate;
	public static volatile SingularAttribute<AbstractChangedByHelper, Admin> updatedByAdmin;

}

