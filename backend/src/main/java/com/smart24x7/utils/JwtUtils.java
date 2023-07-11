package com.smart24x7.utils;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart24x7.bean.User;
import com.smart24x7.config.ReadJWTConfig;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class JwtUtils {

	private ReadJWTConfig jwtConfig;

	public String generateJwtToken(User user) throws JsonProcessingException {
		log.info("JwtUtils :: JWT Token expireIn {}", jwtConfig.getValidity());
		if (!ObjectUtils.isEmpty(user)) {
			String userObj = new ObjectMapper().writeValueAsString(user);
			return Jwts.builder().setSubject((userObj)).setIssuedAt(new Date())
					.setExpiration(new Date((new Date()).getTime() + Long.valueOf(jwtConfig.getValidity())))
					.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecretKey()).compact();
		}
		return null;
	}

	public String getUserFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtConfig.getSecretKey()).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtConfig.getSecretKey()).parseClaimsJws(authToken).getBody();
			return true;
		} catch (SignatureException e) {
			log.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			log.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			log.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			log.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
