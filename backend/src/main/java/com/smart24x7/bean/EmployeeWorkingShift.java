package com.smart24x7.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeWorkingShift implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer isDrop;
	private Integer week;
	private Integer month;
	private Integer year;
	private Integer monday;
	private Integer tuesday;
	private Integer wednesday;
	private Integer thursday;
	private Integer friday;
	private Integer saturday;
	private Integer sunday;
	private Integer mondayIsComNotCom;
	private Integer tuesdayIsComNotCom;
	private Integer wednesdayIsComNotCom;
	private Integer thursdayIsComNotCom;
	private Integer fridayIsComNotCom;
	private Integer saturdayIsComNotCom;
	private Integer sundayIsComNotCom;
	private String mondayModifiedOn;
	private String tuesdayModifiedOn;
	private String wednesdayModifiedOn;
	private String thursdayModifiedOn;
	private String fridayModifiedOn;
	private String saturdayModifiedOn;
	private String sundayModifiedOn;
	private String createdBy;
	private String createdOn;
	private String modifiedBy;
	private String modifiedOn;
	
	

}
