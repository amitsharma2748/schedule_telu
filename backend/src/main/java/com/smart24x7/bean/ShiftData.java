package com.smart24x7.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShiftData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String shiftId;
	private String shiftName;
	private String shiftStartTime;
	private String shiftEndTime;
	private String isDayRollOver;
	private String isAdhoc;
	private String pickType;
	private String dropType;

}
