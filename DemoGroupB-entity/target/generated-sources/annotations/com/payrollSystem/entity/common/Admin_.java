package com.payrollSystem.entity.common;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Admin.class)
public abstract class Admin_ extends com.payrollSystem.entity.abstracts.AbstractAdminEmployeeParent_ {

	public static volatile SingularAttribute<Admin, String> fatherName;
	public static volatile SingularAttribute<Admin, Boolean> isFullTimer;
	public static volatile SingularAttribute<Admin, Gender> gender;
	public static volatile SingularAttribute<Admin, String> grandFatherName;
	public static volatile SingularAttribute<Admin, Branch> branch;
	public static volatile SingularAttribute<Admin, Boolean> isHod;
	public static volatile SingularAttribute<Admin, Date> joinedDate;
	public static volatile SingularAttribute<Admin, Integer> employeeCode;
	public static volatile SingularAttribute<Admin, Boolean> isSalaryMonthly;
	public static volatile SingularAttribute<Admin, Long> homeTelephoneNumber;
	public static volatile SingularAttribute<Admin, Boolean> isDisabled;
	public static volatile SingularAttribute<Admin, Department> department;
	public static volatile SingularAttribute<Admin, Integer> citizenshipNumber;
	public static volatile SingularAttribute<Admin, Boolean> isCollegeSuperAdmin;
	public static volatile SingularAttribute<Admin, Boolean> isCoordinator;
	public static volatile SingularAttribute<Admin, Date> dateOfConfirmation;
	public static volatile SingularAttribute<Admin, String> motherName;
	public static volatile SingularAttribute<Admin, Date> dateOfBirth;
	public static volatile SingularAttribute<Admin, String> panNumber;
	public static volatile SingularAttribute<Admin, Boolean> isAttendanceCompulsory;
	public static volatile SingularAttribute<Admin, String> bloodgroup;
	public static volatile SingularAttribute<Admin, Boolean> isSupervisor;
	public static volatile SingularAttribute<Admin, Designation> designation;
	public static volatile SingularAttribute<Admin, String> spouseName;
	public static volatile SingularAttribute<Admin, Integer> attendanceCode;
	public static volatile SingularAttribute<Admin, String> category;
	public static volatile SingularAttribute<Admin, String> maritalStatus;
	public static volatile SingularAttribute<Admin, String> remarks;

}

