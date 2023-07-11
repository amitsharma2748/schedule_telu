package com.smart24x7.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userMobile;

}
