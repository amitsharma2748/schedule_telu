package com.smart24x7.service;

import java.util.List;

import com.smart24x7.bean.APIResponse;
import com.smart24x7.bean.ApiRequest;
import com.smart24x7.bean.GetPastRosterDetails;
import com.smart24x7.bean.GetShiftsOfMobile;
import com.smart24x7.bean.User;

public interface IUserService {

	APIResponse<GetShiftsOfMobile> getShiftDataByOid(ApiRequest apiRequest, User user);

	APIResponse<List<GetPastRosterDetails>> getRosterDetails(ApiRequest apiRequest, User user);

}
