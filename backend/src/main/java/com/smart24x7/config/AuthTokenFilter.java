package com.smart24x7.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.smart24x7.common.Constants;
import com.smart24x7.exception.UserNotAutharizedException;
import com.smart24x7.utils.JwtUtils;

public class AuthTokenFilter extends OncePerRequestFilter {

	private static final String AUTHENTICATE = "Authenticate";

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (checkLoginRequest(request.getHeader(AUTHENTICATE))) {
			final String jwt = parseJwt(request);
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				filterChain.doFilter(request, response);
			} else {
				throw new UserNotAutharizedException("User not autharized...!");
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

	private boolean checkLoginRequest(String header) {
		if ("true".equals(header))
			return true;
		return false;
	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader(Constants.AUTHORIZATION);
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(Constants.BEARER)) {
			return headerAuth.substring(7, headerAuth.length());
		}
		return null;
	}
}