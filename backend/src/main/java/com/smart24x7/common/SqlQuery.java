package com.smart24x7.common;

public class SqlQuery {

	public static final String PROC_GET_SHIFTSOF_MOBILE_NO_FOR_SCHEDULE = "{call procGetShiftsofMobileNoForSchedule(?,?,?,?,?,?)}";
	public static final String GET_USER_FROM_MOBILE = "{call getUserFromMobile(?)}";
	public static final String GET_PAST_ROSTER_DETAILS_BY_MOBILE = "{call procSelectRosterDetail(?,?,?)}";
}
