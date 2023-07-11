package com.smart24x7.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart24x7.bean.AuthResponse;
import com.smart24x7.bean.LoginRequest;
import com.smart24x7.common.BaseUrls;
import com.smart24x7.service.IAuthService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(BaseUrls.AUTH_BASE_URL)
public class AuthController {

	private IAuthService service;

	@GetMapping(BaseUrls.LOGIN)
	public ResponseEntity<AuthResponse> authenticateUser(LoginRequest loginRequest) {
		log.info("AuthController :: user authenticate start : {} ", loginRequest);
		return ResponseEntity.ok(service.login(loginRequest));
	}
	

}
