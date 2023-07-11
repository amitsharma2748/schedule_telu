package com.smart24x7.bean;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class OrgnizationInfo {

	private Map<String, String> orgInfo;

	public OrgnizationInfo(Map<String, String> orgInfo) {
		this.orgInfo = orgInfo;
	}

	public void setOrgInfo(Map<String, String> orgInfo) {
		this.orgInfo = orgInfo;
	}

	public Map<String, String> getOrgInfo() {
		return orgInfo;
	}
}
