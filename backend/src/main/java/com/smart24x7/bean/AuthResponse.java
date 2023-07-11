package com.smart24x7.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accessToken;
	private String tokenType;
	private Long expireIn;
	private User authUser;

}
