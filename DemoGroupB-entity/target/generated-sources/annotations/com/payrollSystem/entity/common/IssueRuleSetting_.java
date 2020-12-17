package com.payrollSystem.entity.common;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IssueRuleSetting.class)
public abstract class IssueRuleSetting_ extends com.payrollSystem.entity.abstracts.AbstractStatusHelper_ {

	public static volatile SingularAttribute<IssueRuleSetting, Integer> noOfBookAllowed;
	public static volatile SingularAttribute<IssueRuleSetting, Integer> noOfRenewalDays;
	public static volatile SingularAttribute<IssueRuleSetting, Integer> semester;
	public static volatile SingularAttribute<IssueRuleSetting, String> memberType;
	public static volatile SingularAttribute<IssueRuleSetting, Double> finePerExtraDay;
	public static volatile SingularAttribute<IssueRuleSetting, BookCategory> bookCategory;
	public static volatile SingularAttribute<IssueRuleSetting, Integer> noOfRenews;

}

