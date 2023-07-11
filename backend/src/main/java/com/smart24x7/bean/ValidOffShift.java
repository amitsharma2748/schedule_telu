package com.smart24x7.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidOffShift implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String offName;
	private String offTime;
	private String validOffId;

}
