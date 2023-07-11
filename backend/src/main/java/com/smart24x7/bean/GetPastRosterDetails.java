package com.smart24x7.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetPastRosterDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long rdid;
	private Long rosterId;
	private Long shiftId;
	private Long orgId;
	private Date rosterDate;
	private String empMobile;
	private String empName;
	private String empCode;
	private String empGender;
	private String empAddress;
	private String empDesignation;
	private Integer opStatus;
	private String pickupTime;
	private Date pickupDateTime;
	private String pickupLatitude;
	private String pickupLongitude;
	private Integer empStatus;
	private Integer driverAction;
	private Date actualPickupTime;
	private String actualPickupLat;
	private String actualPuckupLong;
	private Integer isEmpDropped;
	private Date actualDropTime;
	private String actualDropLat;
	private String actualDropLong;
	private Integer empPickStatus;
	private Date empPickStatusDateTime;
	private Integer empDropStatus;
	private Date empDropStatusDateTime;
	private Integer isFirstPickupDone;
	private Date actualFirstPickupTime;
	private Integer isPickorDrop;
	private Long vendorId;
	private Date eta;
	private Date shiftStartTime;
	private Date shiftEndTime;
	private String inCmp;
	private Integer lockStatus;
	private Date otaOpsat;

}
