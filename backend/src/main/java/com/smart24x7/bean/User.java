package com.smart24x7.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer piod;
	private Integer clientId;
	private Integer rmid;
	private Integer projectId;
	private String rmName;
	private Integer sid;
	private Integer did;
	private Integer eid;
	private Integer category;
	private String email;
	private String rmEmail;
	private String clientName;
	private String project;
	private String deptName;
	private String empCode;
	private String supMobile;
	private Integer oid;
	private Integer supId;
	private String locatioName;
	private String rmEin;
	private String supEmail;
	private String supEmpCode;
	private String supName;
	private Integer workLocation;
	private String workLocationId;
	private String genderType;
	private String address;
	private Integer isAe;
	private Integer roleId;
	private String emploeeCode;
}
