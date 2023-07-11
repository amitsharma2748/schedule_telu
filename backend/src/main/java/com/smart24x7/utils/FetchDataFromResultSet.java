package com.smart24x7.utils;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smart24x7.bean.EmployeeWorkingShift;
import com.smart24x7.bean.GetPastRosterDetails;
import com.smart24x7.bean.GetShiftsOfMobile;
import com.smart24x7.bean.ShiftData;
import com.smart24x7.bean.User;
import com.smart24x7.bean.ValidOffShift;

public class FetchDataFromResultSet {

	private static final String SHIFT_NAME = "ShiftName";
	private static final String SHIFT_ID = "ShiftID";
	private static final String SHIFT_END_TIME = "ShiftEndTime";
	private static final String SHIFT_START_TIME = "ShiftStartTime";

	private FetchDataFromResultSet() {

	}

	public static User getUserByMobile(ResultSet result) throws SQLException {
		User user = new User();
		while (result.next()) {
			user.setPiod(result.getInt("POID"));
			user.setClientId(result.getInt("CliID"));
			user.setClientName(result.getString("myName"));
			user.setDid(result.getInt("DID"));
			user.setOid(result.getInt("oid"));
			user.setEid(result.getInt("EID"));
			user.setEmpCode(result.getString("EIN"));
			user.setCategory(result.getInt("CAT"));
		}
		return user;
	}

	public static GetShiftsOfMobile getShiftsOfMobile(ResultSet result, CallableStatement cs) throws SQLException {
		GetShiftsOfMobile shiftsOfMobile = new GetShiftsOfMobile();
		getFirstResult(result, shiftsOfMobile);
		getSecondResult(cs, shiftsOfMobile);
		getThirdResult(cs, shiftsOfMobile);
		getFourthResult(cs, shiftsOfMobile);
		getFifthResult(cs, shiftsOfMobile);
		return shiftsOfMobile;
	}

	private static void getFifthResult(CallableStatement cs, GetShiftsOfMobile shiftsOfMobile) throws SQLException {
		boolean isResult = false;
		ResultSet result = null;
		Map<String, List<EmployeeWorkingShift>> map = new HashMap<>();
		List<EmployeeWorkingShift> workingShifts = new ArrayList<>();
		isResult = cs.getMoreResults();
		if (isResult) {
			result = cs.getResultSet();
			while (result.next()) {
				EmployeeWorkingShift empWorkingShift = new EmployeeWorkingShift(); 
				empWorkingShift.setIsDrop(result.getInt("IsDrop"));
				empWorkingShift.setWeek(result.getInt("WEEK"));
				empWorkingShift.setMonth(result.getInt("MONTH"));
				empWorkingShift.setYear(result.getInt("YEAR"));
				empWorkingShift.setMonday(result.getInt("Monday"));
				empWorkingShift.setTuesday(result.getInt("Tuesday"));
				empWorkingShift.setWednesday(result.getInt("Wednesday"));
				empWorkingShift.setThursday(result.getInt("Thusday"));
				empWorkingShift.setFriday(result.getInt("Friday"));
				empWorkingShift.setSaturday(result.getInt("Saturday"));
				empWorkingShift.setSunday(result.getInt("Sunday"));
				empWorkingShift.setMondayIsComNotCom(result.getInt("MondayIsComNotCom"));
				empWorkingShift.setTuesdayIsComNotCom(result.getInt("TuesdayIsComNotCom"));
				empWorkingShift.setWednesdayIsComNotCom(result.getInt("WednesdayIsComNotCom"));
				empWorkingShift.setThursdayIsComNotCom(result.getInt("ThusdayIsComNotCom"));
				empWorkingShift.setFridayIsComNotCom(result.getInt("FridayIsComNotCom"));
				empWorkingShift.setSaturdayIsComNotCom(result.getInt("SaturdayIsComNotCom"));
				empWorkingShift.setSundayIsComNotCom(result.getInt("SundayIsComNotCom"));
				empWorkingShift.setMondayModifiedOn(result.getString("MondayModifiedOn"));
				empWorkingShift.setTuesdayModifiedOn(result.getString("TuesdayModifiedOn"));
				empWorkingShift.setWednesdayModifiedOn(result.getString("WednesdayModifiedOn"));
				empWorkingShift.setThursdayModifiedOn(result.getString("ThursadayModifiedOn"));
				empWorkingShift.setFridayModifiedOn(result.getString("FridayModifiedOn"));
				empWorkingShift.setSaturdayModifiedOn(result.getString("SaturdayModifiedOn"));
				empWorkingShift.setSundayModifiedOn(result.getString("SundayModifiedOn"));
				empWorkingShift.setCreatedBy(result.getString("CreatedBy"));
				empWorkingShift.setCreatedOn(result.getString("CreatedOn"));
				empWorkingShift.setModifiedBy(result.getString("ModifiedBy"));
				empWorkingShift.setModifiedOn(result.getString("ModifiedOn"));
				workingShifts.add(empWorkingShift);
			}
			map.put("employeeWorkingShifts", workingShifts);
			shiftsOfMobile.setFifthResult(map);
		}
		
	}

	private static void getFourthResult(CallableStatement cs, GetShiftsOfMobile shiftsOfMobile) throws SQLException {
		boolean isResult = false;
		ResultSet result = null;
		Map<String, List<ValidOffShift>> map = new HashMap<>();
		List<ValidOffShift> validOffs = new ArrayList<>();
		isResult = cs.getMoreResults();
		if (isResult) {
			result = cs.getResultSet();
			while (result.next()) {
				ValidOffShift validOffShft = new ValidOffShift(); 
				validOffShft.setOffName(result.getString("OffName"));
				validOffShft.setOffTime(result.getString("OffTime"));
				validOffShft.setValidOffId(result.getString("VOID"));
				validOffs.add(validOffShft);
			}
			map.put("validOffs", validOffs);
			shiftsOfMobile.setFourthResult(map);
		}
	}

	private static void getThirdResult(CallableStatement cs, GetShiftsOfMobile shiftsOfMobile)
			throws SQLException {
		boolean isResult = false;
		ResultSet result = null;
		Map<String, List<ShiftData>> map = new HashMap<>();
		List<ShiftData> shiftData = new ArrayList<>();
		isResult = cs.getMoreResults();
		if (isResult) {
			result = cs.getResultSet();
			while (result.next()) {
				ShiftData shfData = new ShiftData();
				shfData.setShiftName(result.getString(SHIFT_NAME));
				shfData.setShiftStartTime(result.getString(SHIFT_START_TIME));
				shfData.setShiftEndTime(result.getString(SHIFT_END_TIME));
				shfData.setShiftId(result.getString(SHIFT_ID));
				shfData.setIsDayRollOver(result.getString("IsDayRollOver"));
				shfData.setIsAdhoc(result.getString("Is_Adhoc"));
				shfData.setPickType(result.getString("PickType"));
				shfData.setDropType(result.getString("DropType"));
				shiftData.add(shfData);
			}
			map.put("workingShift", shiftData);
			shiftsOfMobile.setThirdResult(map);
		}

	}

	private static void getSecondResult(CallableStatement cs, GetShiftsOfMobile shiftsOfMobile)
			throws SQLException {
		boolean isResult = false;
		ResultSet result = null;
		Map<String, List<ShiftData>> map = new HashMap<>();
		List<ShiftData> shiftData = new ArrayList<>();
		isResult = cs.getMoreResults();
		if (isResult) {
			result = cs.getResultSet();
			while (result.next()) {
				ShiftData shfData = new ShiftData();
				shfData.setShiftName(result.getString(SHIFT_NAME));
				shfData.setShiftStartTime(result.getString(SHIFT_START_TIME));
				shfData.setShiftEndTime(result.getString(SHIFT_END_TIME));
				shfData.setShiftId(result.getString(SHIFT_ID));
				shfData.setIsDayRollOver(result.getString("IsDayRollOver"));
				shfData.setIsAdhoc(result.getString("Is_Adhoc"));
				shfData.setPickType(result.getString("PickType"));
				shfData.setDropType(result.getString("DropType"));
				shiftData.add(shfData);
			}
			map.put("workingShift", shiftData);
			shiftsOfMobile.setSecondResult(map);
		}
	}

	private static void getFirstResult(ResultSet result, GetShiftsOfMobile shiftsOfMobile) throws SQLException {
		Map<String, String> map = new HashMap<>();
		while (result.next()) {
			if (result.getString("DSID") != null)
				map.put("DSID", result.getString("DSID"));
			if (result.getString("EmpID") != null)
				map.put("EID", result.getString("EmpID"));
			if (result.getString("PClientID") != null)
				map.put("CID", result.getString("PClientID"));
			if (result.getString("OID") != null)
				map.put("OID", result.getString("OID"));
		}
		shiftsOfMobile.setFirstResult(map);
	}

	public static List<GetPastRosterDetails> getRosterDetails(ResultSet result) throws SQLException {
		List<GetPastRosterDetails> rosterDetails = new ArrayList<>();
		while(result.next()) {
			GetPastRosterDetails details = new GetPastRosterDetails();
			details.setRdid(result.getLong("RDID"));
			details.setRosterId(result.getLong("RosterID"));
			details.setShiftId(result.getLong(SHIFT_ID));
			details.setOrgId(result.getLong("OrganisationID"));
			details.setRosterDate(result.getDate("RosterDate"));
			details.setEmpMobile(result.getString("EmPMobile"));
			details.setEmpName(result.getString("EmpName"));
			details.setEmpCode(result.getString("EmpCode"));
			details.setEmpGender(result.getString("EmpGender"));
			details.setEmpAddress(result.getString("EmpAddress"));
			details.setEmpDesignation(result.getString("EmpDesignation"));
			details.setOpStatus(result.getInt("opstatus"));
			details.setPickupTime(result.getString("PickUpTime"));
			details.setPickupDateTime(result.getDate("PickUpDateTime"));
			details.setPickupLatitude(result.getString("PickupLatitude"));
			details.setPickupLongitude(result.getString("PickUpLongitude"));
			details.setEmpStatus(result.getInt("EmpStatus"));
			details.setDriverAction(result.getInt("DriverAction"));
			details.setActualPickupTime(result.getDate("ActualPickUpTime"));
			details.setActualPickupLat(result.getString("ActualPickUpLatitude"));
			details.setActualPuckupLong(result.getString("ActualPickUpLongitude"));
			details.setIsEmpDropped(result.getInt("IsEmpDropped"));
			details.setActualDropTime(result.getDate("ActualDropTime"));
			details.setActualDropLat(result.getString("ActualDropLatitude"));
			details.setActualDropLong(result.getString("ActualDropLongitude"));
			details.setEmpPickStatus(result.getInt("EmpPickStatus"));
			details.setEmpPickStatusDateTime(result.getDate("EmpPickStatusDateTime"));
			details.setEmpDropStatus(result.getInt("EmpDropStatus"));
			details.setEmpDropStatusDateTime(result.getDate("EmpDropStatusDatetime"));
			details.setIsFirstPickupDone(result.getInt("IsFirstPickUpDone"));
			details.setActualFirstPickupTime(result.getDate("ActualFirstPickTime"));
			details.setIsPickorDrop(result.getInt("IsPickOrDrop"));
			details.setVendorId(result.getLong("VendorID"));
			details.setEta(result.getDate("ETA"));
			details.setShiftStartTime(result.getDate(SHIFT_START_TIME));
			details.setShiftEndTime(result.getDate(SHIFT_END_TIME));
			details.setInCmp(result.getString("InCmp"));
			details.setLockStatus(result.getInt("LockStatus"));
			details.setOtaOpsat(result.getDate("OTAOPSAt"));
			rosterDetails.add(details);
		}
		return rosterDetails;
	}

}
