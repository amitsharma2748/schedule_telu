package com.smart24x7.service;

import com.smart24x7.bean.AuthResponse;
import com.smart24x7.bean.LoginRequest;
import com.smart24x7.bean.User;

public interface IAuthService {

	AuthResponse login(LoginRequest loginRequest);

	User getUserFromJwtToken(String token);

}
