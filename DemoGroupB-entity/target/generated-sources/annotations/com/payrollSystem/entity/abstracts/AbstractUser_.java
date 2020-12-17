package com.payrollSystem.entity.abstracts;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractUser.class)
public abstract class AbstractUser_ extends com.payrollSystem.entity.abstracts.AbstractBlockUnblockHelper_ {

	public static volatile SingularAttribute<AbstractUser, Date> lastPasswordChangedDate;
	public static volatile SingularAttribute<AbstractUser, String> password;
	public static volatile SingularAttribute<AbstractUser, Integer> wrongPasswordAttemptCount;
	public static volatile SingularAttribute<AbstractUser, String> activationCodeOnPromptPassword;
	public static volatile SingularAttribute<AbstractUser, Boolean> isPromptPassword;
	public static volatile SingularAttribute<AbstractUser, Boolean> isActivatedOnPromptPassword;
	public static volatile SingularAttribute<AbstractUser, String> imagePath;
	public static volatile SingularAttribute<AbstractUser, Boolean> isBlocked;
	public static volatile SingularAttribute<AbstractUser, Boolean> isLoggedIn;
	public static volatile SingularAttribute<AbstractUser, String> sessionId;
	public static volatile SingularAttribute<AbstractUser, Date> lastLoggedInTime;
	public static volatile SingularAttribute<AbstractUser, String> username;

}

