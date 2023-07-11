package com.smart24x7.utils;

import javax.servlet.http.HttpServletRequest;

import com.smart24x7.common.Constants;

public class CommonUtility {

	private CommonUtility() {

	}

	public static String getJwtToken(HttpServletRequest request) {
		String headerAuth = request.getHeader(Constants.AUTHORIZATION);
		return headerAuth.substring(7, headerAuth.length());
	}
}
