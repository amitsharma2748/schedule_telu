package com.smart24x7.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetShiftsOfMobile implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, String> firstResult;
	private Map<String, List<ShiftData>> secondResult;
	private Map<String, List<ShiftData>> thirdResult;
	private Map<String, List<ValidOffShift>> fourthResult;
	private Map<String, List<EmployeeWorkingShift>> fifthResult;

}
