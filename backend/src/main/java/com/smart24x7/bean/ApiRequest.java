package com.smart24x7.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private String oid;
	private String mobile;
	private String empCode;
	private String fromDate;
	private String toDate;
}
