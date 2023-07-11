package com.smart24x7.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart24x7.bean.APIResponse;
import com.smart24x7.bean.ApiRequest;
import com.smart24x7.bean.GetPastRosterDetails;
import com.smart24x7.bean.GetShiftsOfMobile;
import com.smart24x7.bean.OrgnizationInfo;
import com.smart24x7.bean.User;
import com.smart24x7.common.BaseUrls;
import com.smart24x7.common.Messages;
import com.smart24x7.exception.UserNotAutharizedException;
import com.smart24x7.service.IAuthService;
import com.smart24x7.service.IUserService;
import com.smart24x7.utils.CommonUtility;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(BaseUrls.USER_BASE_URL)
public class UserController {

	private OrgnizationInfo orgInfo;

	private IUserService iUserService;

	private IAuthService iAuthService;

	@GetMapping(BaseUrls.GET_LOGGED_IN_USER)
	public ResponseEntity<OrgnizationInfo> getLoggedInUser(HttpServletRequest request) {
		log.info("Inside AuthController to Login user {} ");
		return ResponseEntity.ok(orgInfo);
	}

	@GetMapping(BaseUrls.GET_SHIFTS_BY_OID)
	public ResponseEntity<APIResponse<GetShiftsOfMobile>> getShiftDataByOid(ApiRequest apiRequest,
			HttpServletRequest request) {
		log.info("Get shift data by OID...");
		User user = iAuthService.getUserFromJwtToken(CommonUtility.getJwtToken(request));
		if (!ObjectUtils.isEmpty(user) && StringUtils.equalsIgnoreCase(apiRequest.getEmpCode(), user.getEmpCode())) {
			return ResponseEntity.ok(iUserService.getShiftDataByOid(apiRequest, user));
		}
		throw new UserNotAutharizedException(Messages.USER_NOT_AUTHORIZED);
	}

	@GetMapping(BaseUrls.GET_PAST_ROSTER_DETAILS)
	public ResponseEntity<APIResponse<List<GetPastRosterDetails>>> getRosterDetails(ApiRequest apiRequest,
			HttpServletRequest request) {
		log.info("Fetching past roster details...");
		User user = iAuthService.getUserFromJwtToken(CommonUtility.getJwtToken(request));
		if (!ObjectUtils.isEmpty(user) && StringUtils.equalsIgnoreCase(apiRequest.getEmpCode(), user.getEmpCode())) {
			return ResponseEntity.ok(iUserService.getRosterDetails(apiRequest, user));
		}
		throw new UserNotAutharizedException(Messages.USER_NOT_AUTHORIZED);
	}
}
