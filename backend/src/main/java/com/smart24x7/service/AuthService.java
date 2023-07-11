package com.smart24x7.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart24x7.bean.AuthResponse;
import com.smart24x7.bean.LoginRequest;
import com.smart24x7.bean.User;
import com.smart24x7.config.ReadJWTConfig;
import com.smart24x7.exception.UserNotAutharizedException;
import com.smart24x7.repository.IUserRepository;
import com.smart24x7.utils.JwtUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

	private static final String BEARER = "Bearer";

	private JwtUtils jwtUtils;

	private ReadJWTConfig jwtConfig;

	private IUserRepository iUserRepository;

	@Override
	public AuthResponse login(LoginRequest loginRequest) {
		log.info("AuthService :: User authentication start...");
		try {
			if(!ObjectUtils.isEmpty(loginRequest.getUserMobile())) {
				Optional<User> user = Optional.ofNullable(iUserRepository.getUserByMobile(loginRequest.getUserMobile()));
				if (user.isPresent()) {
					log.info("AuthService :: User is authenticated.....");
					return AuthResponse.builder().accessToken(jwtUtils.generateJwtToken(user.get())).authUser(user.get())
							.tokenType(BEARER).expireIn(Long.valueOf(jwtConfig.getValidity())).build();
				} else {
					log.error("AuthService :: User is not autharized.....");
					throw new UserNotAutharizedException("UnAutharized user...!");
				}
			}else {
				log.error("AuthService :: Mobile is mandatory.....");
				throw new UserNotAutharizedException("Mobile is mandatory..!");
			}
			
		} catch (JsonProcessingException e) {
			log.error("AuthService :: Error in jwt token processing");
		}
		return null;
	}

	@Override
	public User getUserFromJwtToken(String token) {
		try {
			return new ObjectMapper().readValue(jwtUtils.getUserFromJwtToken(token), User.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
