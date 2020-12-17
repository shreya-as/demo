package com.payrollSystem.entity.abstracts;

import com.payrollSystem.entity.common.Admin;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractBlockUnblockHelper.class)
public abstract class AbstractBlockUnblockHelper_ extends com.payrollSystem.entity.abstracts.AbstractStatusHelper_ {

	public static volatile SingularAttribute<AbstractBlockUnblockHelper, String> blockedReason;
	public static volatile SingularAttribute<AbstractBlockUnblockHelper, Date> lastUnBlockedDate;
	public static volatile SingularAttribute<AbstractBlockUnblockHelper, Date> lastBlockedDate;
	public static volatile SingularAttribute<AbstractBlockUnblockHelper, Admin> blockedByAdmin;
	public static volatile SingularAttribute<AbstractBlockUnblockHelper, Admin> unBlockedByAdmin;
	public static volatile SingularAttribute<AbstractBlockUnblockHelper, String> unBlockedReason;

}

