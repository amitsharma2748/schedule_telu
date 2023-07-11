package com.smart24x7.repository;

import java.util.List;

import com.smart24x7.bean.GetPastRosterDetails;
import com.smart24x7.bean.GetShiftsOfMobile;
import com.smart24x7.bean.User;

public interface IUserRepository {

	GetShiftsOfMobile getShiftDataByOid(Integer did, Integer oid, String mobile, int week, int month, int year);

	User getUserByMobile(String mobile);

	List<GetPastRosterDetails> getRosterDetails(String formDate, String toDate, String mobile);

}
