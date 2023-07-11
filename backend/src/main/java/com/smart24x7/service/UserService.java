package com.smart24x7.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smart24x7.bean.APIResponse;
import com.smart24x7.bean.ApiRequest;
import com.smart24x7.bean.GetPastRosterDetails;
import com.smart24x7.bean.GetShiftsOfMobile;
import com.smart24x7.bean.User;
import com.smart24x7.common.Messages;
import com.smart24x7.common.Status;
import com.smart24x7.exception.RosterDetailsNotFoundException;
import com.smart24x7.repository.IUserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements IUserService {

	private IUserRepository iUserRepository;

	@Override
	public APIResponse<GetShiftsOfMobile> getShiftDataByOid(ApiRequest apiRequest, User user) {
		log.info("UserService :: Fetching shift data start...");
		GetShiftsOfMobile shiftDataObj = iUserRepository.getShiftDataByOid(user.getDid(), user.getOid(),
				apiRequest.getMobile(), 2, 9, 2022);
		return APIResponse.<GetShiftsOfMobile>builder().status(String.valueOf(Status.SUCCESS))
				.message(Messages.DATA_FETCHED).results(shiftDataObj).build();
	}

	@Override
	public APIResponse<List<GetPastRosterDetails>> getRosterDetails(ApiRequest apiRequest, User user) {
		List<GetPastRosterDetails> rosterData = iUserRepository.getRosterDetails("2022-12-01", "2022-12-01",
				apiRequest.getMobile());
		if (!rosterData.isEmpty()) {
			return APIResponse.<List<GetPastRosterDetails>>builder().status(String.valueOf(Status.SUCCESS))
					.message(Messages.DATA_FETCHED).results(rosterData).build();
		}
		throw new RosterDetailsNotFoundException(Messages.DATA_NOT_FOUND);
	}

}
